import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;
import java.lang.*;


public class Common {
    

    public static Map <String, String> importAlphabetFromFile(String filename) {
        Map <String, String> alphabet = new HashMap<>();
        String line;
        String letter;
        String morseLetter;

        try {
            Scanner file = new Scanner(new File(filename));
            
            while (file.hasNextLine()) {
                line = file.nextLine();
                letter = line.split(" ")[0];
                morseLetter = line.split(" ")[1];
                
                alphabet.put(letter, morseLetter);
            }
            
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return alphabet;
    }

    public static Map <String, String> changeKeyAndValue(Map <String, String> alphabet) {
        Map <String, String> newAlphabet = new HashMap<>();
        Set <String> keys = alphabet.keySet();
        String key;
        String value;

        for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
            key = it.next();
            value = alphabet.get(key);
            newAlphabet.put(value, key);
        }

        return newAlphabet;
    }


    public static void displayMenu(Map <String, String> map) {
        String value;
        String key;
        System.out.println("Ciphers to choose: ");
        for (int i = 1; i <= map.size(); i++) {
            key = Integer.toString(i);
            value = map.get(key);
            System.out.format("     %s.   %s \n", key, value);
        }

    }


    public static void displayWord(String word) {
        System.out.println(word);
    }


}
