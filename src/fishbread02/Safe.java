package fishbread02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Safe {
    private final Map<String, AtomicInteger> ledger = new ConcurrentHashMap<>();

    public void store(String customerName, int amount) {
        ledger.computeIfAbsent(customerName, k -> new AtomicInteger(0)).addAndGet(amount);
    }

    public int getBalance() {
        return ledger.values().stream().mapToInt(AtomicInteger::get).sum();
    }

    public Map<String, AtomicInteger> getLedger() {
        return ledger;
    }
}