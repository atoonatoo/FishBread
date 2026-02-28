import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FishBreadSeller seller = new FishBreadSeller();
        Customer customer = new Customer(10000);

        while (true) {
            System.out.print("\n1.메뉴판 2.구매 3.빵봉투 4.먹기 5.소지금 6.붕어빵장수 금고 0. 종료");
            System.out.println("선택");
            int choice = sc.nextInt();

            if (choice == 1) seller.showMenu();

            else if (choice == 2) {
                seller.showMenu();
                System.out.println("종류 번호 : ");
                int typeIdx = sc.nextInt() - 1;
                System.out.println("구매 게수  : ");
                int count = sc.nextInt();

                if (typeIdx >= 0 && typeIdx < FishBreadType.values().length && count > 0) {
                    customer.buyFishBread(seller, FishBreadType.values()[typeIdx], count);
                }
            }

            else if (choice == 3) customer.showInventory();

            else if (choice == 4) {
                customer.showInventory();

                    System.out.println("먹을 붕어빵 번호 : ");
                    int input = sc.nextInt();

                    customer.eatFishBread(input - 1);
            } else if (choice == 5) System.out.println("내 소지금 : " + customer.getWalletBalance() + "원");

            else if (choice == 6) {
                System.out.println("붕어빵 장수 금고 : " + seller.checkSafeBalance() + "원");
            } else if (choice == 0) break;
        }
        sc.close();
    }
}