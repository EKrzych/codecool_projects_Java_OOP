package com.codecool.java.geometry.shapes;

public class Triangle extends Shape {
    float a;
    float b;
    float c;
    

    public Triangle() {
        this.a = 1;
        this.b = 2;
        this.c = 3;  
    }

    public Triangle(float a, float b, float c) {
        checkIfArgsGreaterThanZero(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;  
    }

    public float getA() {
        return this.a;
    }

    public float getB() {
        return this.b;
    }

    public float getC() {
        return this.c;
    }

    public double calculateArea() {
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public double calculatePerimeter() {
        return a + b + c;
    }

    public String getAreaFormula() {
        return "sqrt(s(s-a)(s-b)(s-c)), s=(a+b+c)/2";
    }

    public String getPerimeterFormula() {
        return "a + b + c";
    }

    public String toString() {
        return "Triangle, a=" + (int)a + " b=" + (int)b + " c=" + (int)c ;
    }

}
