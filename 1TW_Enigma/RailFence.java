import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;

public class RailFence {

    public static String enciphereWord(String word, String key) {
        int row = Integer.parseInt(key);

        if (row > 0) {
            int len = word.length();
            int numberInRow = len/row + 1;
            int usedLetters = 0;
            char letters[][] = new char[row][numberInRow];
            String encipheredWord = "";

            // Distributes letters into an array
            for (int i = 0; i < numberInRow; i++){
                for (int j = 0; j < row; j++){
                    if (usedLetters != len){
                        letters[j][i] = word.charAt(usedLetters);
                        usedLetters += 1;
                    }
                }
            }

            // Converts distributed letters into a string
            for (int i = 0; i < row; i++){
                for (int j = 0; j < numberInRow; j++){
                    encipheredWord += letters[i][j];
                } 
            }    
        return encipheredWord;
        } else {
            System.out.println("Your key cannot be 0 or less.");
        }   
    return "Cannot ciphre.";  
    }

    public static String deciphereWord(String word, String key){
        int row = Integer.parseInt(key);

        if (row > 0) {
            int len = word.length();
            int numberInRow = len/row;
            int usedLetters = 0;
            char letters[][] = new char[row][numberInRow];
            String decipheredWord = "";

            // Distributes letters into an array
            for (int i = 0; i < row; i++){
                for (int j = 0; j < numberInRow; j++){
                    if (usedLetters != len){
                        letters[i][j] = word.charAt(usedLetters++);
                    }
                }
            }

            // Converts distributed letters into a string
            for (int i = 0; i < numberInRow; i++){
                for (int j = 0; j < row; j++){
                    decipheredWord += letters[j][i];
                } 
            } 
        return decipheredWord; 
        } else {
            System.out.println("Your key cannot be 0 or less.");
        }   
    return "Cannot ciphre.";  
    }

    public static void main(String []args){
        String key1 = "0";
        String text1 = "Love, love from here!";
        String text2 = "Leler ro,o ohev vfme!";
        String newText = RailFence.enciphereWord(text1, key1);
        String newText2 = RailFence.deciphereWord(text2, key1);
        System.out.println(newText);
        System.out.println(newText2);
    }
}