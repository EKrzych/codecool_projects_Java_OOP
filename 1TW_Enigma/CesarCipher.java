import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;

public class CesarCipher {

    public static String enciphereWord(String alphabet, String word, String key) {
        int convKey = Integer.parseInt(key);
        try {
            int len = word.length();
            String encipheredWord = "";
            word = word.toUpperCase();
        
            for (int i=0; i<len; i++){
                int index = alphabet.indexOf(word.charAt(i));
                if (index >= 0){
                    encipheredWord += CesarCipher.enciphereLetter(alphabet, word.charAt(i), convKey);
                } else {
                    encipheredWord += word.charAt(i);     
                }
            }
            return encipheredWord; 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Your key must be between 1 and 26.");
        }   
    return "Cannot ciphre.";
    }


    public static String enciphereLetter(String alphabet, char letter, int key){
        String newAlphabet = CesarCipher.getAlphabet(alphabet, key);
        int index = newAlphabet.indexOf(letter);
        char charLetter = newAlphabet.charAt(index + key);
        String encipheredLetter = Character.toString(charLetter);

        return encipheredLetter;
    }

    public static String getAlphabet(String alphabet, int key){
        String newAlphabet = alphabet.concat(alphabet.substring(0, key));
        return newAlphabet;
    }

    public static void main(String []args){
        String text = "aaaBcc A/";
        String key1 = "27";
        String newAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlphabet1 = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String enText = CesarCipher.enciphereWord(newAlphabet, text, key1);
        String enText1 = CesarCipher.enciphereWord(newAlphabet1, text, key1);
        System.out.println(enText);
        System.out.println(enText1);
    }
    
}