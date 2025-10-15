package basic;

import java.util.Scanner;

public class Condition {

    public static void main(String[] args) {

        System.out.print("자연수를 입력하세요: ");
        Scanner sc = new Scanner(System.in);

        int value = Integer.parseInt(sc.nextLine());
        System.out.println("입력한 값은 " + value + "입니다");

        if (value % 2 == 0) {
            System.out.println("짝수 입니다.");
        } else {
            System.out.println("홀수 입니다.");
        }

        if (value < 100) {
            System.out.println("100미만 입니다.");
        } else if (value > 100) {
            System.out.println("100초과 입니다.");
        } else {
            System.out.println("100입니다.");
        }

        switch(value % 2) {
            case 0:
                System.out.println("짝수 입니다.");
                break;
            default:
                System.out.println("홀수 입니다.");

        }
    }

}