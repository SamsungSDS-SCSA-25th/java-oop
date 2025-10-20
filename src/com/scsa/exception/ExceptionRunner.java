package com.scsa.exception;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionRunner {

    public static void main(String[] args) {
        System.out.println("=====Exception Test=====");

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");

        // InputMismatchException
        try {
            Integer i = scanner.nextInt();
            test(i);
        } catch (InputMismatchException e) {
            System.out.println("올바른 정수로 입력하세요!");
            System.out.println((Arrays.toString(e.getStackTrace())));
        } finally {
            scanner.close();
            System.out.println("끝");
        }

        // ArrayIndexOutOfBoundsException
        int[] arr = {1,2,3,4,5};
        try {
            System.out.println(arr[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println((Arrays.toString(e.getStackTrace())));
        }

    }

    private static void test(Integer num) {

        // ArithmeticException
        try {
            Integer result = 99 / num;
            System.out.println("result = " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println((Arrays.toString(e.getStackTrace())));
        }

    }

}
