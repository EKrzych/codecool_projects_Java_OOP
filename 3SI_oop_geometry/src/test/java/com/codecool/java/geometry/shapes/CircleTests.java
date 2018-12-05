package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CircleTests {
    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float radius = 3;

        Circle c = new Circle(radius);

        assertEquals(radius, c.getR(), delta);
    }

    @Test
    void testZeroRadius() {
        float radius = 0;
        String expectedMessage = "All arguments must be greater than 0";

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(radius);
        });
        assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    void testNegativeRadius() {
        float radius = -3;
        String expectedMessage = "All arguments must be greater than 0";

        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(radius);
        });
        assertEquals(expectedMessage, e.getMessage());
    }

    @Test
    void testGetArea() {
        float radius = 3;
        double expectedArea = 28.27433;

        Circle c = new Circle(radius);

        assertEquals(expectedArea, c.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float radius = 3;
        double expectedPerimeter = 18.84956;

        Circle c = new Circle(radius);

        assertEquals(expectedPerimeter, c.calculatePerimeter(), delta);
    }
}
