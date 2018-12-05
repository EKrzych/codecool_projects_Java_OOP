package com.codecool.java.geometry.shapes;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle() {
        super(1, 1, 1);
 
    }
    
    public EquilateralTriangle(float a) {
        super(a, a, a);
 
    }

    public String toString() {
        return "EquilateralTriangle, a = " + (int)a;
    }
}
