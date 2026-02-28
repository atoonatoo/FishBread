import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int wallet;
    private final List<FishBread> myInventory = new ArrayList<>();

    public Customer(int initialMoney) {
        this.wallet = initialMoney;
    }

    public void buyFishBread(FishBreadSeller seller, FishBreadType type, int count) {
        int totalPrice = type.getPrice() * count;

        if (wallet < totalPrice) {
            System.out.println("잔액이 부족합니다. : 필요 금액 : " + totalPrice + "원(현재 소지금 : " + wallet + ")");
            return;
        }

        List<FishBread> bought = seller.sell(type, count, totalPrice);
        wallet -= totalPrice;
        myInventory.addAll(bought);

        System.out.println(type.getName() + "붕어빵" + count + "개를 구매했습니다. (총 " + totalPrice + "원)");
    }

    public void eatFishBread(int index) {
        if (index < 0 || index >= myInventory.size()) {
            System.out.println("먹을 수 있는 붕어빵이 없습니다.");
            return;
        }
        FishBread fishBread = myInventory.remove(index);
        System.out.println("아이 맛있다~" + fishBread.getTypeName() + "맛이네~ (남은 붕어빵 " + myInventory.size() + "개)");
    }

    public void showInventory() {
        System.out.println("---빵봉투---");
        if (myInventory.isEmpty()) System.out.println("비어 있습니다.");
        for (int i = 0; i < myInventory.size(); i++) {
            System.out.println(i + 1 + ". " + myInventory.get(i).getTypeName() + "붕어빵");
        }
    }

    public int getWalletBalance() {
        return wallet;
    }

    public int getInventorySize() {
        return myInventory.size();
    }
}
