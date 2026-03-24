// Inside FraudDetectionService.java
import com.scholarship.sentinel.util.FraudRules;

public boolean isFraudulent(Transaction tx) {
    // Use the rules from the utility class
    int window = FraudRules.VELOCITY_WINDOW_SECONDS;
    int limit = FraudRules.MAX_TRANSACTIONS_PER_WINDOW;
    
    // ... rest of the Redis logic ...
}