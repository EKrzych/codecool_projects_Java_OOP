package com.codecool.java.geometry.shapes;
import com.codecool.java.NotYetImplementedException;
import java.util.*;

/**
 * This is a abstract class representing geometrical shape.
 */
public abstract class Shape{
    /**
     * Calculates shape's area.
     * @return area of the shape
     */
    public abstract double calculateArea();

    /**
     * Calculates shape's perimeter.
     * @return perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * Check if any of args are not below 0.
     * Throws IllegalArgumentException if any of the parameters is 0 or less.
     * @param args
     * @return true if any of args are greater than 0
     */
    public static boolean checkIfArgsGreaterThanZero(float... args) {
        for (float item : args) {
            if (item <= 0) {
                throw new IllegalArgumentException("All arguments must be greater than 0");
            }
        }
        return true;
    }

    /**
     * Returns formula for the area of the shape as a string.
     * @return area formula
     */
    public abstract String getAreaFormula();

    /**
     * Returns formula for the perimeter of the shape as a string.
     * @return perimeter formula
     */
    public abstract String getPerimeterFormula();

    
}
