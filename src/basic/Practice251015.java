package basic;

import java.math.BigInteger;

public class Practice251015 {

    public static void main(String[] args) {

        System.out.println("문제풀이 시작");
        p1();
        p2();
        p3();
        p4();
        p5();
        p6();
        p7();
        p8();
        System.out.println("문제풀이 끝");
    }

    private static void p1() {
        // 1
        System.out.println("#1");
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void p2() {
        // 2
        System.out.println("#2");
        int sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                sum2 += i;
            }
        }
        System.out.println(sum2);
    }

    private static void p3() {
        // 3
        System.out.println("#3");
        int count3 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 8 == 0) {
                count3++;
            }
        }
        System.out.println(count3);
    }

    private static void p4() {
        // 4
        System.out.println("#4");
        int count4 = 1;
        int num4 = 2;
        while (count4 < 100) {
            count4++;
            num4 += 6;
        }
        System.out.println(num4);
    }

    private static void p5() {
        // 5
        System.out.println("#5");
        BigInteger num5 = BigInteger.valueOf(2);
        System.out.println(num5);
        int count5 = 1;
        while (count5 < 50) {
            num5 = num5.multiply(BigInteger.valueOf(3));
            System.out.println(num5);
            count5++;
        }
        System.out.println(num5);
    }

    private static void p6() {
        // 6
        System.out.println("#6");
        BigInteger[] fibonacci = new BigInteger[50];
        fibonacci[0] = BigInteger.ONE;
        fibonacci[1] = BigInteger.ONE;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        for (BigInteger fibo : fibonacci) {
            System.out.println(fibo);
        }
    }

    private static void p7() {
        // 7
        System.out.println("#7");
        BigInteger sum7 = BigInteger.ZERO;
        for (int i = 1; i <= 100; i++) {
            BigInteger temp = BigInteger.ONE;
            for (int j = 1; j <= i; j++) {
                temp = temp.multiply(BigInteger.valueOf(j));
            }
            sum7 = sum7.add(temp);
        }
        System.out.println(sum7);
    }

    private static void p8() {
        // 8
        System.out.println("#8");
        BigInteger sum8 = BigInteger.ZERO;
        for (int i = 1; i <= 100; i++) {
            BigInteger temp = BigInteger.ONE;
            for (int j = 1; j <= i; j++) {
                temp = temp.multiply(BigInteger.valueOf(j));
            }

            if (i % 2 == 0) {
                sum8 = sum8.add(temp);
            } else {
                sum8 = sum8.subtract(temp);
            }
        }
        System.out.println(sum8);
    }

}
