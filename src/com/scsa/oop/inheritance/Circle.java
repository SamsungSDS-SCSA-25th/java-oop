package com.scsa.oop.inheritance;

public class Circle extends Shape {

    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calArea() {
        super.area = Math.PI * radius * radius;
    }

}
