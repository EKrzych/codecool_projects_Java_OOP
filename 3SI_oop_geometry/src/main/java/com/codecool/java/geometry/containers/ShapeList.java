package com.codecool.java.geometry.containers;
import com.codecool.java.geometry.shapes.*;
import com.codecool.java.geometry.*;
import java.lang.*;
import java.util.*;
import java.io.*;

public class ShapeList {
    List<Shape> myShapes = new ArrayList<Shape>();
    
    public void addNewShape() {
        String item = UserInput.askWhichShape();
        switch(item) {
            case "Circle": case "1":
                int radius = UserInput.askInteger("radius");
                myShapes.add(new Circle(radius));
                break;
            case "Triangle": case "2":
                int a = UserInput.askInteger("first side's length");
                int b = UserInput.askInteger("second side's length");
                int c = UserInput.askInteger("third side's length");
                myShapes.add(new Triangle(a, b, c));
                break;
            case "Equilateral triangle": case "3":
                int d = UserInput.askInteger("side's length");
                myShapes.add(new EquilateralTriangle(d));
                break;
            case "Rectangle": case "4":
                int e = UserInput.askInteger("first side's length");
                int f = UserInput.askInteger("second side's length");
                myShapes.add(new Rectangle(e, f));
                break;
            case "Square": case "5":
                int g = UserInput.askInteger("side's length");
                myShapes.add(new Square(g));
                break;
            case "Regular Pentagon": case "6":
                int h = UserInput.askInteger("side's length");
                myShapes.add(new RegularPentagon(h));
                break;
            default :
                System.out.println("There's no such option");

        }
    }

    public void addShape(Shape shape) {
        myShapes.add(shape);
    }

    public String getShapesTable() {
        List <String> myStringTable = new ArrayList<String>();
        int i = 0;
        for (Shape item : myShapes) {
            String tempString = String.format("|%-2d|", i)
                                    + String.format("%-20s",item.getClass().getSimpleName())
                                    + String.format("|%-30s|",item.toString())
                                    + String.format("%-10.2f", item.calculatePerimeter())
                                    + String.format("|%-10s|", item.getPerimeterFormula())
                                    + String.format("%-10.2f", item.calculateArea())
                                    + String.format("|%-35s|", item.getAreaFormula());
            i++;
            myStringTable.add(tempString);
        }
        return String.join("\n", myStringTable);
    }

    public Shape getShapeAt(int index) {
        return myShapes.get(index);
    }

    public Shape getLargestShapeByPerimeter() {
        return Collections.max(myShapes, new PerimeterComparator());
    }

    public Shape getLargestShapeByArea() {
         return Collections.max(myShapes,new AreaComparator());
    }

     public void displayFormula() {
        String item = UserInput.askWhichShape();
        switch(item) {
            case "Circle": case "1":
                System.out.println("Area: " +new Circle().getAreaFormula());
                System.out.println("Perimeter: " +new Circle().getPerimeterFormula());
                break;
            case "Triangle": case "2":
                System.out.println("Area: " +new Triangle().getAreaFormula());
                System.out.println("Perimeter: " +new Triangle().getPerimeterFormula());
                break;
            case "Equilateral triangle": case "3":
                System.out.println("Area: " +new EquilateralTriangle().getAreaFormula());
                System.out.println("Perimeter: " +new EquilateralTriangle().getPerimeterFormula());
                break;
            case "Rectangle": case "4":
                System.out.println("Area: " +new Rectangle().getAreaFormula());
                System.out.println("Perimeter: " +new Rectangle().getPerimeterFormula());
                break;
            case "Square": case "5":
                System.out.println("Area: " +new Square().getAreaFormula());
                System.out.println("Perimeter: " +new Square().getPerimeterFormula());
                break;
            case "Regular Pentagon": case "6":
                System.out.println("Area: " +new RegularPentagon().getAreaFormula());
                System.out.println("Perimeter: " +new RegularPentagon().getPerimeterFormula());
                break;
            default :
                System.out.println("There's no such option");

        }
    }
}
