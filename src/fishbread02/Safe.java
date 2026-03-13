package fishbread02;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Safe {
    private final Map<Customer, Integer> ledger = new ConcurrentHashMap<>();

    public void store(Customer customer, int amount) {
        ledger.merge(customer, amount, Integer::sum);
    }

    public int getBalance() {
        return ledger.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Map<Customer, Integer> getLedger() {
        return Collections.unmodifiableMap(ledger);
    }
}