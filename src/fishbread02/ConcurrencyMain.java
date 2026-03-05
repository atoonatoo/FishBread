package fishbread02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcurrencyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FishBreadSeller seller = new FishBreadSeller();

        System.out.print("고객수 : ");
        int numberOfCustomers = sc.nextInt();
        int initialMoney = 10000;

        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer(initialMoney, seller));
        }

        for (Customer c : customers) {
            c.start();
        }

        for (Customer c : customers) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n[ 최종 판매 보고서 ]");

        int totalSoldQuantity = 0;
        int totalCustomerSpent = 0;

        int redBean = 0, cream = 0, hot = 0;

        for (Customer c : customers) {
            totalCustomerSpent += (initialMoney - c.getWalletBalance());

            for (FishBread fb : c.getFishBreads()) {
                totalSoldQuantity++;
                if (fb.getTypeName().equals("팥")) redBean++;
                else if (fb.getTypeName().equals("크림")) cream++;
                else if (fb.getTypeName().equals("매운")) hot++;
            }
        }

        int sellerRevenue = seller.checkSafeBalance();

        System.out.println("----------------------------------------------");
        System.out.println("1. 종류별 판매 개수:");
        System.out.println("   - 팥 붕어빵   : " + redBean + "개");
        System.out.println("   - 크림 붕어빵 : " + cream + "개");
        System.out.println("   - 매운 붕어빵 : " + hot + "개");
        System.out.println("2. 총 판매 개수 : " + totalSoldQuantity + "개");
        System.out.println("3. 고객 지출 총액: " + totalCustomerSpent + "원");
        System.out.println("4. 장수 금고 잔액: " + sellerRevenue + "원");
        System.out.println("----------------------------------------------");

        if (totalCustomerSpent == sellerRevenue) {
            System.out.println("결과 : 금액이 정확히 일치합니다.");
        } else {
            System.out.println("결과 : 금액에 오차가 발생했습니다.");
        }

        sc.close();
    }
}