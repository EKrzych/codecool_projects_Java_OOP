package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTests {
    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float a = 3;
        float b = 4;

        Rectangle r = new Rectangle(a, b);

        assertAll("Rectangle fields", () -> {
            assertEquals(a, r.getA(), delta);
            assertEquals(b, r.getB(), delta);
        });
    }

    @Test
    void testZeroSide() {
        float a = 3;
        float b = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(a, b);
        });
    }

    @Test
    void testOneNegativeSide() {
        float a = -3;
        float b = 4;

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(a, b);
        });
    }

    @Test
    void testAllNegativeSides() {
        float a = -3;
        float b = -4;

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(a, b);
        });
    }


    @Test
    void testGetArea() {
        float a = 3;
        float b = 4;
        double expectedArea = 12;

        Rectangle r = new Rectangle(a, b);

        assertEquals(expectedArea, r.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float a = 3;
        float b = 4;
        double expectedPerimeter = 14;

        Rectangle r = new Rectangle(a, b);

        assertEquals(expectedPerimeter, r.calculatePerimeter(), delta);
    }
}
