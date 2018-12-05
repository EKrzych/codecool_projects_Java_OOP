import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;


public class AtbashCipher {
    private  String word;
    private  String encipheredWord;
    private Map <String, String> alphabet;

    public AtbashCipher(String word) {
        this.word = word;
        this.alphabet = Common.importAlphabetFromFile("atbashalphabet.txt");
        this.encipheredWord = setEncipherWord(word);
    }


    public  String setEncipherWord(String word) {
        String encipheredWord = new String();
        String letter;

        for (int i = 0; i < word.length(); i++) {
            letter = Character.toString(word.charAt(i)).toUpperCase();
            
            if (letter.equals(" ")) {
                encipheredWord += letter;
            } else {
                if(!this.alphabet.containsKey(letter)) {
                    throw new IllegalArgumentException("Wrong word.");
                }
                encipheredWord += this.alphabet.get(letter);
            }
            
        }

        return encipheredWord;
    }


    public String getEncipherWord(){
        return this.encipheredWord;
    }


    public String getDecipherWord(){
        return this.encipheredWord;
    }
}


