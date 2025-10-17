package com.scsa.oop.inheritance;

public abstract class Shape {

    protected double area;

    @Override
    public String toString() {
        return "Shape{" +
                "area=" + area +
                '}';
    }

    abstract void calArea();

}
