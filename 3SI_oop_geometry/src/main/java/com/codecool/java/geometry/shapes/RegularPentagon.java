package com.codecool.java.geometry.shapes;

public class RegularPentagon extends Shape {
    float a;

    public RegularPentagon() {
        this.a = 1;
    }

    public RegularPentagon(float a) {
        checkIfArgsGreaterThanZero(a);
        this.a = a;
    }

    public float getA() {
        return this.a;
    }

    public double calculateArea() {
        return (a * a * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))))/4;
    }

    public double calculatePerimeter() {
        return 5 * a;
    }

    public String getAreaFormula() {
        return "(a2 sqrt(5(5+2sqrt(5))))/4";
    }

    public String getPerimeterFormula() {
        return "5a";
    }

    public String toString() {
        return "RegularPentagon, a = " + (int)a;
    }
}
