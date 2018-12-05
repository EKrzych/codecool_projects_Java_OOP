import java.io.*;
import java.util.*;
import java.text.*; 
class Polybius {
    
    static String [][] keySquare = {{"p","h","q","g","m",")","!","@","#","C"},
                                    {"e","a","y","l","n","$","^","&","*","D"},
                                    {"o","f","d","x","k","?",",","`","~","E"},
                                    {"r","c","v","s","z","{","}","[","]","F"},
                                    {"w","b","u","t","i","ą",";","ć","ę","H"},
                                    {"1","2","3","4","5","ń","ś","ź","ó","I"},
                                    {"6","7","8","9","0","ł","(",".","%","J"},
                                    {" ","j",";","Z","W","V","U","A","B","K"},
                                    {"L","M","N","O","P","G","Q","R","S","T"},
                                    {"w","b","u","t","i","ą",";","ć","ę","H"}};

    private static Map <Integer, String> keyMap = new HashMap<>();

    private static Set convertToSet(String key){
        Set <Character> keySet = new HashSet<Character>();
        for (int i = 0; i < key.length(); i++){
            keySet.add(new Character(key.charAt(i)));
        }
        return keySet;
    }
    
    private static void createKey(String key){
            if (key.length() != 10 || key.length() != convertToSet(key).size()){
                throw new NullPointerException();
            }
            for(int i = 0 ; i < (key.length() - 1) ; i++){
                    keyMap.put(i, key.substring(i, i+1));
            }
        }
    
    private static String getEncipherLetter(String letter) {
        int itemInRow = keySquare[0].length;
        String encipheredLetter = "";

        for (Integer i = 0 ; i < keySquare.length ; i++){
            for (Integer j = 0 ; j < itemInRow ; j++) {
                if (String.valueOf(letter).equals(keySquare[i][j])) {
                    encipheredLetter = keyMap.get(i) + keyMap.get(j);
                    return encipheredLetter;
                }
            }
        }
        return "";
    }

    public static String encipher(String word, String key){
        Polybius.createKey(key);
        String encipheredWord = "";
        for (int i = 0 ; i < word.length() ; i ++){
            encipheredWord += getEncipherLetter(String.valueOf(word.charAt(i)));
        }
        return encipheredWord;
    }

    public static String decipher(String word, String key){
        Polybius.createKey(key);
        String decipheredWord = "";
        for (int i = 0; i < (word.length() - 1) ; i += 2){
            decipheredWord += getDecipherLetter(word.substring(i, i+1), word.substring(i+1, i+2), keySquare);
        }
        return decipheredWord;
    }
        
    private static String getDecipherLetter(String firstLetter, String secondLetter, String [][] keySquare) {
        Integer i = null;
        Integer j = null;

        for (Map.Entry<Integer, String> entry : keyMap.entrySet()){
            if (firstLetter.equals(entry.getValue())){
                i = entry.getKey();
            }
            if (secondLetter.equals(entry.getValue())){
                j = entry.getKey();
            }
        }
    return keySquare[i][j];
    }
}