package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TriangleTests {
    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float a = 3;
        float b = 4;
        float c = 5;

        Triangle t = new Triangle(a, b, c);

        assertAll("Trangle fields", () -> {
            assertEquals(a, t.getA(), delta);
            assertEquals(b, t.getB(), delta);
            assertEquals(c, t.getC(), delta);
        });
    }

    @Test
    void testZeroSide() {
        float a = 3;
        float b = 0;
        float c = 5;

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, b, c);
        });
    }

    @Test
    void testOneNegativeSide() {
        float a = -3;
        float b = 4;
        float c = 5;

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, b, c);
        });
    }

    @Test
    void testAllNegativeSides() {
        float a = -3;
        float b = -4;
        float c = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(a, b, c);
        });
    }

    @Test
    void testGetArea() {
        float a = 3;
        float b = 4;
        float c = 5;
        double expectedArea = 6;

        Triangle t = new Triangle(a, b, c);

        assertEquals(expectedArea, t.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float a = 3;
        float b = 4;
        float c = 5;
        double expectedPerimeter = 12;

        Triangle t = new Triangle(a, b, c);

        assertEquals(expectedPerimeter, t.calculatePerimeter(), delta);
    }
}
