package com.scsa.basic;

public class Operator {

    public static void main(String[] args) {

        System.out.println(3/5);
        System.out.println(3.0/5);
        System.out.println( (float)(3/5));
        System.out.println( (float)3/5);

        System.out.println(3%5);

        int a, b, c;
        a = 10;
        b = 20;
        c = a++;
        System.out.println(a);
        System.out.println(c);

        c = ++b;
        System.out.println(b);
        System.out.println(c);

    }

}
