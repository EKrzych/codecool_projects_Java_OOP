package com.codecool.java.geometry.shapes;

public class Rectangle extends Shape {
    float a;
    float b;

    public Rectangle() {
        this.a = 1;
        this.b = 1;
    }

    public Rectangle(float a, float b) {
        checkIfArgsGreaterThanZero(a, b);
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return this.a;
    }

    public float getB() {
        return this.b;
    }

    public double calculateArea() {
        return a * b;
    }

    public double calculatePerimeter() {
        return 2*a + 2*b;
    }

    public String getAreaFormula() {
        return "a×b";
    }

    public String getPerimeterFormula() {
        return "2a + 2b";
    }

    public String toString() {
        return "Rectangle, a = " + (int)a + ", b = " + (int)b;
    }
}
