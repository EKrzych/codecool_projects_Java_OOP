package com.codecool.java.geometry.containers;

import com.codecool.java.geometry.shapes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeListTests {
    ShapeList shapeList;

    @BeforeEach
    void init() {
        shapeList = new ShapeList();
    }

    @Test
    void testAddDifferentShapes() {
        Circle expectedFirst = new Circle(5);
        Square expectedSecond = new Square(2);

        shapeList.addShape(expectedFirst);
        shapeList.addShape(expectedSecond);

        assertEquals(expectedFirst, shapeList.getShapeAt(0));
        assertEquals(expectedSecond, shapeList.getShapeAt(1));
    }

    @Test
    void testLargestPerimeter() {
        ShapeList shapeList = new ShapeList();
        RegularPentagon p = new RegularPentagon(3);
        Triangle t = new Triangle(2, 4, 5);
        Circle c = new Circle(3);
        Square expectedWithLargestPerimeter = new Square(5);

        shapeList.addShape(p);
        shapeList.addShape(expectedWithLargestPerimeter);
        shapeList.addShape(t);
        shapeList.addShape(c);

        Shape shapeWithLargestPerimeter = shapeList.getLargestShapeByPerimeter();

        assertEquals(expectedWithLargestPerimeter, shapeWithLargestPerimeter);
    }

    @Test
    void testLargestArea() {
        ShapeList shapeList = new ShapeList();
        RegularPentagon p = new RegularPentagon(3);
        Square s = new Square(5);
        Triangle t = new Triangle(2, 4, 5);
        Circle expectedWithLargestArea = new Circle(3);

        shapeList.addShape(p);
        shapeList.addShape(s);
        shapeList.addShape(t);
        shapeList.addShape(expectedWithLargestArea);

        Shape shapeWithLargestArea = shapeList.getLargestShapeByArea();

        assertEquals(expectedWithLargestArea, shapeWithLargestArea);
    }
}