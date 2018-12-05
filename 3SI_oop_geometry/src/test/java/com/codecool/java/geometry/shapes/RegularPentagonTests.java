package com.codecool.java.geometry.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegularPentagonTests {
    float delta = 0.00001f;

    @Test
    void testPositiveSides() {
        float a = 3;

        RegularPentagon p = new RegularPentagon(a);

        assertEquals(a, p.getA(), delta);
    }

    @Test
    void testZeroSide() {
        float a = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            new RegularPentagon(a);
        });
    }

    @Test
    void testNegativeSide() {
        float a = -3;

        assertThrows(IllegalArgumentException.class, () -> {
            new RegularPentagon(a);
        });
    }

    @Test
    void testGetArea() {
        float a = 3;
        double expectedArea = 15.4843;

        RegularPentagon p = new RegularPentagon(a);

        assertEquals(expectedArea, p.calculateArea(), delta);
    }

    @Test
    void testGetPerimeter() {
        float a = 3;
        double expectedPerimeter = 15;

        RegularPentagon p = new RegularPentagon(a);

        assertEquals(expectedPerimeter, p.calculatePerimeter(), delta);
    }

}
