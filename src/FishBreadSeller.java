import java.util.ArrayList;
import java.util.List;

public class FishBreadSeller {
    private final Safe safe = new Safe();

    public void showMenu() {
        System.out.println("\n--- 붕어빵 메뉴판 ---");
        for (FishBreadType type : FishBreadType.values()) {
            System.out.println((type.ordinal() + 1) + ". " + type.getName() + "붕어빵 : " + type.getPrice() + "원");
        }
    }

    public List<FishBread> sell(FishBreadType type, int count, int totalPayment) {
        List<FishBread> box = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            box.add(new FishBread(type));
        }
        safe.store(totalPayment);
        return box;
    }

    public int checkSafeBalance() {
        return safe.getBalance();
    }
}