package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EquilateralTriangleTests {

    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float a = 2;

        Triangle t = new EquilateralTriangle(a);


        assertAll("Equilateral triangle fields", () -> {
            assertEquals(a, t.getA(), delta);
            assertEquals(a, t.getB(), delta);
            assertEquals(a, t.getC(), delta);
        });
    }

    @Test
    void testZeroSide() {
        float a = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            new EquilateralTriangle(a);
        });
    }

    @Test
    void testNegativeSide() {
        float a = -3;

        assertThrows(IllegalArgumentException.class, () -> {
            new EquilateralTriangle(a);
        });
    }

    @Test
    void testGetArea() {
        float a = 3;
        double expectedArea = 3.89711;

        Triangle t = new EquilateralTriangle(a);

        assertEquals(expectedArea, t.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float a = 3;
        double expectedPerimeter = 9;

        Triangle t = new EquilateralTriangle(a);

        assertEquals(expectedPerimeter, t.calculatePerimeter(), delta);
    }
}
