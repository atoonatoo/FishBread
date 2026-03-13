package fishbread02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FishBreadSeller {
    private final Safe safe = new Safe();

    public List<FishBread> sell(Customer customer, FishBreadType type, int count, int totalPayment) {
        List<FishBread> fishBreads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fishBreads.add(new FishBread(type));
        }

        safe.store(customer, totalPayment);
        return fishBreads;
    }

    public int checkSafeBalance() {
        return safe.getBalance();
    }

    public Map<Customer, Integer> getLedger() {
        return safe.getLedger();
    }
}