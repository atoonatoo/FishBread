package fishbread01;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FishBreadSeller seller = new FishBreadSeller();
        Customer customer = new Customer(10000);

        while (true) {
            System.out.print("\n1.구매 2.먹기 3.소지금 4.붕어빵장수 금고 5.종료");
            System.out.println("선택");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\n--- 붕어빵 메뉴판 ---");
                for (FishBreadType type : FishBreadType.values()) {
                    System.out.println((type.ordinal() + 1) + ". " + type.getName() + "붕어빵 : " + type.getPrice() + "원");
                }

                System.out.println("종류 번호 : ");
                int typeIdx = sc.nextInt() - 1;
                System.out.println("구매 게수  : ");
                int count = sc.nextInt();

                if (typeIdx >= 0 && typeIdx < FishBreadType.values().length && count > 0) {
                    FishBreadType selectedType = FishBreadType.values()[typeIdx];

                    boolean isSuccess = customer.buyFishBread(seller, selectedType, count);

                    if (isSuccess) {
                        System.out.println(selectedType.getName() + "붕어빵 " + count + "개를 구매했습니다.");
                        System.out.println("(총 " + (selectedType.getPrice() * count) + "원)");
                    } else {
                        System.out.println("잔액이 부족하여 구매에 실패했습니다.");
                        System.out.println("현재 소지금: " + customer.getWalletBalance() + "원");
                    }
                }
            }

            else if (choice == 2) {
                List<FishBread> fishBreads = customer.getFishBreads();

                System.out.println("\n--- 소유한 붕어빵 목록 ---");
                if (fishBreads.isEmpty()) {
                    System.out.println("비어 있습니다.");
                } else {
                    for (int i = 0; i < fishBreads.size(); i++) {
                        System.out.println((i + 1) + ". " + fishBreads.get(i).getTypeName() + "붕어빵");
                    }
                }

                System.out.println("먹을 붕어빵 번호 : ");
                int input = sc.nextInt();

                FishBread eaten = customer.eatFishBread(input - 1);

                if (eaten != null) {
                    System.out.println("아이 맛있다~ " + eaten.getTypeName() + "맛이네~");
                    System.out.println("(남은 붕어빵 " + customer.getFishBreadsSize() + "개)");
                } else {
                    System.out.println("먹을 수 있는 붕어빵이 없습니다. 번호를 다시 확인해 주세요.");
                }
            }

            else if (choice == 3) System.out.println("내 소지금 : " + customer.getWalletBalance() + "원");

            else if (choice == 4) {
                System.out.println("붕어빵 장수 금고 : " + seller.checkSafeBalance() + "원");
            }
            else if (choice == 5) break;
        }
        sc.close();
    }
}