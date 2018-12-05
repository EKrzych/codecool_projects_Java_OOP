import java.io.*;
import java.util.*;

class Baconian {
    private static Map <String, String> keySquare = new HashMap<>();

    private static void readCodeMap() {
        try (Scanner file = new Scanner(new File("Baconian.txt"))) { 
            String line;
            
            while(file.hasNextLine()) {
                line = file.nextLine();
                String letter = line.split(",")[0];
                String code = line.split(",")[1];
            
                keySquare.put(letter, code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    public static String encipher(String word){
        Baconian.readCodeMap();
        String encipheredWord = "";
        for (int i = 0 ; i < word.length() ; i ++){
            encipheredWord += getEncipherLetter(String.valueOf(word.charAt(i)));
        }
        return encipheredWord;
    }

    private static String getEncipherLetter(String letter) {
        letter = letter.toUpperCase();
        if (keySquare.get(letter) != null){
            String encipheredLetter = keySquare.get(letter);
            return encipheredLetter;
        } else {
            return "     ";
        }
    }
    
    public static String decipher(String word){
        Baconian.readCodeMap();
        String decipheredWord = "";
        for (int i = 0, j = 5; j <= word.length() ; i += 5, j += 5){
            decipheredWord += getDecipherSubstring(word.substring(i,j));
        }
        if (decipheredWord.equals("")) {
            throw new IllegalArgumentException();
        }
        return decipheredWord;
    }

    private static String getDecipherSubstring(String substring) {
        String letter = "";
        for (Map.Entry<String, String> entry : keySquare.entrySet()){
            if (substring.equals(entry.getValue())){
                letter = entry.getKey();
            }
        }
        return letter;
    }
}

