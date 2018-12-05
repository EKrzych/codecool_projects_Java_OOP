package com.codecool.java.geometry;
import com.codecool.java.geometry.containers.ShapeList;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    ShapeList shapes = new ShapeList();
	    boolean isRunning = true;

	    while (isRunning) {
	        int option = UserInput.askWhichOption();

            switch (option) {
                case 1:
                    shapes.addNewShape();
                    break;
                case 2:
                    System.out.println(shapes.getShapesTable());
                    break;
                case 3:
                     System.out.println(shapes.getLargestShapeByPerimeter());
                    break;
                case 4:
                    System.out.println(shapes.getLargestShapeByArea());
                    break;
                case 5:
                    shapes.displayFormula();
                    break;
                case 6:
                    isRunning = false;
                    break;
            }
        }
    }
}
