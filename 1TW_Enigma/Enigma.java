import java.io.*;
import java.util.*;
import java.nio.file.*;


class Enigma {

    private static String readtext() {
        String textToConvert ="";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            
            while((line = br.readLine()) != null) {
                textToConvert = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textToConvert;
    }   

    public static void handleMenu(String textToConvert, String args[]) {
        String cipherMethod = args[0];
        String cipherName;
        String key = null;
        if (args.length == 3) {
                key = args[2];
            }

        if (cipherMethod.equals("-l")) {
            cipherName = null;
        }
        else {
            cipherName = args[1]; 
        }
        
        switch (cipherMethod){
                case "-e":
                    switch (cipherName){
                        case "Atbash": case "1":
                            AtbashCipher atbash = new AtbashCipher(textToConvert);
                            Common.displayWord(atbash.getEncipherWord());
                            break;
                        case "Baconian": case "2":
                            Common.displayWord(Baconian.encipher(textToConvert));
                            break;
                        case "FractionatedMorse": case "3":
                            FractionatedMorseCipher morse = new FractionatedMorseCipher(textToConvert, true);
                            Common.displayWord(morse.getMorseWord());
                            Common.displayWord(morse.getEncipherWord());
                            break;
                        case "Polybius": case "4":
                            Common.displayWord(Polybius.encipher(textToConvert, key));
                            break;
                        case "Cesar": case "5":
                            String thisAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
                            Common.displayWord(CesarCipher.enciphereWord(thisAlphabet, textToConvert, key));
                            break;
                        case "RailFence": case "6":  
                            Common.displayWord(RailFence.enciphereWord(textToConvert, key));
                            break;
                    }
                    break;
                case "-d":
                    switch (cipherName){
                        case "Atbash": case "1":
                            AtbashCipher atbash = new AtbashCipher(textToConvert);
                            Common.displayWord(atbash.getDecipherWord());
                            break;
                        case "Baconian": case "2":
                            Common.displayWord(Baconian.decipher(textToConvert));
                            break;
                        case "FractionatedMorse": case "3":
                            FractionatedMorseCipher morse = new FractionatedMorseCipher(textToConvert, false);
                            Common.displayWord(morse.getMorseWord());
                            Common.displayWord(morse.getDecipherWord());
                            break;
                        case "Polybius": case "4":
                            Common.displayWord(Polybius.decipher(textToConvert, key));
                            break;
                        case "Cesar": case "5":
                            String thisAlphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";   
                            Common.displayWord(CesarCipher.enciphereWord(thisAlphabet, textToConvert, key));
                            break;
                        case "RailFence": case "6":  
                            Common.displayWord(RailFence.deciphereWord(textToConvert, key));
                            break;
                    }
                    break;
                case "-l":
                    Common.displayMenu(Common.importAlphabetFromFile("cipherlist.txt"));
                    break;
        }
    }

    
    public static void main(String args[]) {
        String textToConvert = Enigma.readtext();
        try{
            Enigma.handleMenu(textToConvert, args);
        } catch(ArrayIndexOutOfBoundsException e1){
            System.err.println("Choose method and cipher.");
        } catch (NullPointerException e2){
            System.err.println("Choose proper key (10 characters, no duplicates).");
        } catch (IllegalArgumentException e3){
            System.err.println("Wrong word.");
        }
    }
}


