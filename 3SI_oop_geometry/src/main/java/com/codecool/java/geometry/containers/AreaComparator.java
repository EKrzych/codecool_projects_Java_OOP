package com.codecool.java.geometry.containers;
import com.codecool.java.geometry.shapes.*;
import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {

    public int compare(Shape item1, Shape item2) {
        if (item1.calculateArea() < item2.calculateArea()) {
            return -1;
        } else {
            return 1;
        }
    }
}