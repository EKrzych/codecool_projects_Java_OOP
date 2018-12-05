package com.codecool.java.geometry.shapes;

public class Circle extends Shape {
    float r;

    public Circle() {
        this.r = 1;
    }

    public Circle(float r) {
        checkIfArgsGreaterThanZero(r);
        this.r = r;
    }

    public float getR() {
        return this.r;
    }

    public double calculateArea() {
        return Math.PI * r * r;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * r;
    }
    
    public String getAreaFormula() {
        return "π×r2";
    }
    
    public String getPerimeterFormula() {
        return "2×π×r";
    }

    public String toString() {
        return "Circle, r = " + (int)r;
    }
}
