package com.scsa.oop.inheritance;

public class ShapeRunner {

    public static void main(String[] args) {

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(3, 4);

        circle.calArea();
        System.out.println(circle);

        rectangle.calArea();
        System.out.println(rectangle);

    }

}
