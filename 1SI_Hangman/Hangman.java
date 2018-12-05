import java.io.*;
import java.util.*;
import java.text.*;

class Hangman {
    static boolean userWon = false;

    private static String[] readArray(String filename) {
        String[] stringArr = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            List<String> my_collection = new ArrayList<String>();
            while((line = br.readLine()) != null) {
                my_collection.add(line);
            }
            stringArr = my_collection.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArr;    
    }

    private static void printHangman(int life) {
        String [] filenameArray = {"pict_hangman0.txt", 
                         "pict_hangman1.txt", 
                         "pict_hangman2.txt", 
                         "pict_hangman3.txt", 
                         "pict_hangman4.txt", 
                         "pict_hangman5.txt",
                         "pict_hangman6.txt",};
        String pictureFilename = filenameArray[life];
        String [] picture = Hangman.readArray(pictureFilename);
        for (String element : picture){
             System.out.println(element);
        }
    }

    public static class Score implements Serializable {
        public String name;
        public String formatedDate;
        public String guessingTime;
        public int guessingTries;
        public String guessedWord;
        public long time;

        public Score(String name, String formatedDate, String guessingTime, int guessingTries, String guessedWord, long time) {
            this.name = name;
            this.formatedDate = formatedDate;
            this.guessingTime = guessingTime;
            this.guessingTries = guessingTries;
            this.guessedWord = guessedWord;
            this.time = time;
        }

        public String toString() { 
            return name + "|" + formatedDate + "|" + guessingTime + "|" + guessingTries + "|" + guessedWord;  
        } 
    }

    private static String choose_country_capital(String [] array) {
        int index = new Random().nextInt(array.length);
        return array[index];
    }

    private static String[] stringToArray(String myString) {
        myString = myString.toUpperCase();
        String[] array = myString.split(" \\| ");
        return array;
    }

    private static char[] hideCapital(String[] array) {
        char[] hiddenWordLetter = new char[array[1].length()];
        Arrays.fill(hiddenWordLetter, '_');
        return hiddenWordLetter;
    }

    private static void printHiddenCapital(char[] hiddenCapital) {
        for (char letter : hiddenCapital){
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    private static String askUser(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        return inputString;
    }

    private static char getLetter() {
        System.out.println("Give me your letter:");
        Scanner input = new Scanner(System.in);
        char letter = input.next().charAt(0);
        letter = Character.toUpperCase(letter);
        return letter;
    }

    private static String getWord() {
        System.out.println("Give me your word:");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        word = word.toUpperCase();
        return word;
    }

    private static void giveHint(int life, String[] chosenCountryCapitalArray) {
        if (life == 1){
            System.out.println("You're looking for capital of " + chosenCountryCapitalArray[0]);
        }
    }

    private static void printInformation(int life, Set <String> notInWord, int guessTries, char[] hiddenCapital, String[] chosenCountryCapitalArray) {
        System.out.print("\033[H\033[2J");
        System.out.println("Life: " + life);
        System.out.println("Letters not in word" + notInWord);
        System.out.println("You have tried: " + guessTries + " times");         
        Hangman.printHangman(life);
        Hangman.printHiddenCapital(hiddenCapital);
        Hangman.giveHint(life, chosenCountryCapitalArray);    
    }

    private static int guessLetter(int life, String[] chosenCountryCapitalArray, char[] hiddenCapital, Set <String> notInWord) {
        char guessedLetter = Hangman.getLetter();
        if (chosenCountryCapitalArray[1].indexOf(guessedLetter) >= 0) {
            for (int i = 0 ; i < chosenCountryCapitalArray[1].length() ; i++ ) {
                if (chosenCountryCapitalArray[1].charAt(i) == guessedLetter){
                    hiddenCapital[i] = guessedLetter;
                } 
            }
            if (String.valueOf(hiddenCapital).equals(chosenCountryCapitalArray[1])) {
                System.out.println("You won!!!");
                userWon = true;
            }
        } else {
            notInWord.add(Character.toString(guessedLetter));
            life -= 1;
        }
        return life;
    }

    private static int game(String[] chosenCountryCapitalArray, char[] hiddenCapital) {
        int MAX_LIFE = 6;
        int life = MAX_LIFE;
        Set <String> notInWord = new HashSet <String>();
        int guessTries = 0;

        while (life > 0 && !userWon) {
            Hangman.printInformation(life, notInWord, guessTries, hiddenCapital, chosenCountryCapitalArray);
            String letterOrWord = Hangman.askUser("Would you like to guess Letter or Word?(L/W)");
            switch(letterOrWord){
                case "L": case "l":
                    life = Hangman.guessLetter(life, chosenCountryCapitalArray, hiddenCapital, notInWord);
                    guessTries += 1;
                break;

                case "W": case "w":
                    String guessedWord = Hangman.getWord();
                    if (guessedWord.equals(chosenCountryCapitalArray[1])) {
                        System.out.println("You won!!!");
                        userWon = true;
                    } else {
                        life -=2;
                    }
                    guessTries += 1;
                break;
            }
        }
        System.out.println("GAME OVER!");
        if (life == 0){
            Hangman.printHangman(life);
        }
        return guessTries;
    }

    public static void writeToFile(Score newRecord) {
        try (FileWriter fw = new FileWriter("score.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.println(newRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printScore(String filename) {
        String [] scoreArray = Hangman.readArray(filename);
        for(String s : scoreArray) {
            System.out.println(s);
        }               
    }

    public static Score gatherData(long time, String[] chosenCountryCapitalArray, int guessingTries){
        Date date = new Date();
        String name = Hangman.askUser("What's your name? ");
        String formatedDate = String.format("%td.%<tm.%<tY", date );
        String guessingTime = String.format("%1$TM:%1$TS", time);
        String guessedWord = chosenCountryCapitalArray[1];
        Score newRecord = new Score(name, formatedDate, guessingTime, guessingTries, guessedWord, time);

        return newRecord;
    }

    public static void main(String args[]) {
        String another_try = "yes";

        while (another_try.equals("yes")) {
            try { 
                userWon = false;
                another_try = "No";
                String filename = "score.txt";
                
                String[] countryCapitalArray = Hangman.readArray("countries_and_capitals.txt");
                String chosen_pair = Hangman.choose_country_capital(countryCapitalArray);
                String[] chosenCountryCapitalArray = Hangman.stringToArray(chosen_pair);
                System.out.println(Arrays.toString(chosenCountryCapitalArray));
                char[] hiddenCapital = Hangman.hideCapital(chosenCountryCapitalArray);
                long start = System.currentTimeMillis();
                int guessingTries = Hangman.game(chosenCountryCapitalArray, hiddenCapital);
                long end = System.currentTimeMillis( );
                long time = end - start;
                
                if (userWon) {
                    Score newRecord = Hangman.gatherData(time, chosenCountryCapitalArray, guessingTries);
                    Hangman.writeToFile(newRecord);
	            }
                Hangman.printScore(filename);
                another_try = Hangman.askUser("Would you like to play again?(yes/no)");
            } catch (Exception e) {
                System.out.println("Got an exception!");
                e.printStackTrace();
            }
        }
    }
}