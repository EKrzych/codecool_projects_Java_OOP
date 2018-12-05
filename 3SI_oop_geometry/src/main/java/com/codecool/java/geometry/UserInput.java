package com.codecool.java.geometry;
import com.codecool.java.geometry.containers.ShapeList;
import java.util.*;

public class UserInput {
    static String [] optionArray = {"Add new shape.",
                                    "Show all shapes",
                                    "Show shape with the largest perimeter",
                                    "Show shape with the largest area",
                                    "Display formula",
                                    "Quit"};
    
    static String [] shapesArray = {"Circle", "Triangle", "Equilateral triangle",
                            "Rectangle", "Square", "Regular Pentagon"};
    

    public static int askWhichOption() {
        System.out.println("\nWhat would you like to do?");
        for (int i = 0; i < optionArray.length; i++) {
            System.out.println(i+1 + ". " + optionArray[i]);
        }
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static String askWhichShape() {
        System.out.println("Which shape you choose?");
        for (int i = 0; i < shapesArray.length; i++) {
            System.out.println(i+1 + ". " + shapesArray[i]);
        }
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static int askInteger(String data) {
        System.out.println("Provide " + data + ":");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }



}