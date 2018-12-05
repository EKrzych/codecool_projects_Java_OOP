package com.codecool.java.geometry.containers;
import com.codecool.java.geometry.shapes.*;
import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {

    public int compare(Shape item1, Shape item2) {
        if (item1.calculatePerimeter() < item2.calculatePerimeter()) {
            return -1;
        } else {
            return 1;
        }
    }
}
