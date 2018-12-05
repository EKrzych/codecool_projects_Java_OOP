package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTests {
    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float a = 3;

        Square s = new Square(a);

        assertAll("Square fields", () -> {
            assertEquals(a, s.getA(), delta);
            assertEquals(a, s.getB(), delta);
        });
    }

    @Test
    void testZeroSide() {
        float a = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            new Square(a);
        });
    }

    @Test
    void testNegativeSide() {
        float a = -3;

        assertThrows(IllegalArgumentException.class, () -> {
            new Square(a);
        });
    }

    @Test
    void testGetArea() {
        float a = 3;
        double expectedArea = 9;

        Square s = new Square(a);

        assertEquals(expectedArea, s.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float a = 3;
        double expectedPerimeter = 12;

        Square s = new Square(a);

        assertEquals(expectedPerimeter, s.calculatePerimeter(), delta);
    }
}
