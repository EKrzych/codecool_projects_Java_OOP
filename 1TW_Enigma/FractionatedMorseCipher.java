import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.file.*;
import java.lang.*;


public class FractionatedMorseCipher {
    private String word;
    private String morseWord;
    private String newWord;
    private boolean encriper;
    private Map <String, String> alphabetLM;
    private Map <String, String> alphabetML;

    
    public FractionatedMorseCipher(String word, boolean encriper) {
        this.encriper = encriper;
        this.alphabetLM = getAlphabetLetterMorseL();
        this.alphabetML = getAlphabetMorseLLetter();
        this.word = word;
        this.morseWord = getMorseWord();
        this.newWord = getNewWord();
    }


    public String getNewWord() {
        if (this.encriper) {
            return setEncipheredWord();
        } 
        else {
            return setDecipheredWord();
        }
    }

    
    public String getMorseWord() {
        if (this.encriper) {
            return setEncipheredMorseWord();
        } 
        else {
            return setDecipheredMorseWord();
        }
    }
    

    public Map <String, String> getAlphabetLetterMorseL() {
        String filename;

        if (this.encriper) {
            filename = "morsealphabet.txt";
        } 
        else {
            filename = "morsealphabet2.txt";
        }

        return Common.importAlphabetFromFile(filename);
    }


    public Map <String, String> getAlphabetMorseLLetter() {
        String filename;

        if (this.encriper) {
            filename = "morsealphabet2.txt";
        } 
        else {
            filename = "morsealphabet.txt";
        }

        return Common.changeKeyAndValue(Common.importAlphabetFromFile(filename));
    }
    

    public String setEncipheredMorseWord() {
        String encipheredMorseWord = new String();
        String letter;

        for (int i = 0; i < this.word.length(); i++) {
            letter = Character.toString(this.word.charAt(i)).toUpperCase();

            if (!letter.equals(" ")) {
                if(!this.alphabetLM.containsKey(letter)) {
                    throw new IllegalArgumentException("Wrong word.");
                }

                encipheredMorseWord += this.alphabetLM.get(letter);
            }
            
            encipheredMorseWord += "x";
        }

        return encipheredMorseWord;
    }


    public String setEncipheredWord() {
        String encipheredWord = new String();
        String morseLetter;

        while(this.morseWord.length() % 3 != 0) {
            this.morseWord += "x";
        }


        for (int i = 0; i < this.morseWord.length(); i += 3) {

            morseLetter = this.morseWord.substring(i, i+3);
            encipheredWord += this.alphabetML.get(morseLetter);
        }

        return encipheredWord;
    }


    public String setDecipheredMorseWord() {
        String decipheredMorseWord = new String();
        String letter;

        for (int i = 0; i < this.word.length(); i++) {
            letter = Character.toString(this.word.charAt(i)).toUpperCase();
            decipheredMorseWord += this.alphabetLM.get(letter);
        }

        return decipheredMorseWord;
    }


    public String setDecipheredWord() {
        String decipheredWord = new String();
        String [] morseLetters = this.morseWord.split("x");
        String morseLetter;

        for (int i = 0; i < morseLetters.length; i ++) {
            morseLetter = morseLetters[i];
            if (morseLetter.equals("")) {
                decipheredWord += " ";
            } 
            else {
                if(!this.alphabetML.containsKey(morseLetter)) {
                    throw new IllegalArgumentException("Wrong word.");
                } 
                else {
                    decipheredWord += this.alphabetML.get(morseLetter);
                }
            }       
        }

        return decipheredWord;
    }


    public String getEncipherWord() {
        return this.newWord;
    }


    public String getDecipherWord() {
        return this.newWord;
    }
}