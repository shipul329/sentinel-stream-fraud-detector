package com.sentinel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * REDIS CONFIGURATION - SENTINEL FRAUD ENGINE
 * This configuration enables the application to store and retrieve Transaction
 * objects as JSON, which is essential for the Sliding Window logic.
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        
        // Use the provided connection factory (Lettuce by default in Spring Boot 3)
        template.setConnectionFactory(connectionFactory);

        // 1. Key Serializer: Use String for human-readable keys in Redis (e.g., "user:tx:window:123")
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        // 2. Value Serializer: Use Jackson2Json to store the Transaction Record as a JSON string
        // This allows the FraudDetectionService to analyze transaction data stored in Redis.
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 3. Initialize the template
        template.afterPropertiesSet();
        
        return template;
    }
}