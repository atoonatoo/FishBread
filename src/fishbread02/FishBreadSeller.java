package fishbread02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FishBreadSeller {
    private final Safe safe = new Safe();

    public List<FishBread> sell(Customer customer, FishBreadType type, int count, int totalPayment) {
        List<FishBread> fishBreads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fishBreads.add(new FishBread(type));
        }

        safe.store(customer.getName(), totalPayment);
        return fishBreads;
    }

    public int checkSafeBalance() {
        return safe.getBalance();
    }

    public Map<String, AtomicInteger> getLedger() {
        return safe.getLedger();
    }
}