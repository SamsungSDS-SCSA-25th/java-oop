package com.scsa.basic;

import java.util.Scanner;

public class YearAndAnimal {

    public static void main(String[] args) {

        // 배열 선언
        String []arr = {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};

        System.out.print("년도를 입력하세요: ");
        Scanner sc = new Scanner(System.in);

        int year = Integer.parseInt(sc.nextLine());
        System.out.println("입력한 년도는 " + year + "이고, 현재 동물은 " + arr[year % 12] + "입니다.");

        /*
            switch(year % 12) {
            case 0:
                System.out.println("원숭이");
                break;
            case 1:
                System.out.println("닭");
                break;
            case 2:
                System.out.println("개");
                break;
            case 3:
                System.out.println("돼지");
                break;
            case 4:
                System.out.println("쥐");
                break;
            case 5:
                System.out.println("소");
                break;
            case 6:
                System.out.println("호랑이");
                break;
            case 7:
                System.out.println("토끼");
                break;
            case 8:
                System.out.println("용");
                break;
            case 9:
                System.out.println("뱀");
                break;
            case 10:
                System.out.println("말");
                break;
            case 11:
                System.out.println("양");
                break;
            default:
                break;
         */
    }
}
