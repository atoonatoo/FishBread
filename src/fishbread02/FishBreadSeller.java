package fishbread02;

import java.util.ArrayList;
import java.util.List;

public class FishBreadSeller {
    private final Safe safe = new Safe();

    public List<FishBread> sell(FishBreadType type, int count, int totalPayment) {
        List<FishBread> fishBreads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fishBreads.add(new FishBread(type));
        }
        safe.store(totalPayment);
        return fishBreads;
    }

    public int checkSafeBalance() {
        return safe.getBalance();
    }
}