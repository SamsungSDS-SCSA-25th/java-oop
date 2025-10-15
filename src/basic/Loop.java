package basic;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("실행하시려면 y/ 중지하려면 n을 입력하세요: ");
            String line = scan.nextLine();

            if (line.equals("y")) {
                System.out.println("실행되었습니다.");
            } else if (line.equals("n")) {
                System.out.println("중지되었습니다.");
                break;
            }
        }
    }

}
