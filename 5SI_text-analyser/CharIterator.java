import java.util.*;

class CharIterator implements Iterator {
    int index;
    private ArrayList<String> letters;

    CharIterator(FileContent fileContent) {
        createLetters(fileContent);
    }

    private void createLetters(FileContent fileContent) {
        letters = new ArrayList<String>();
        int i;
        for(i=0; i < fileContent.getTextToAnalyse().length()-1; i++) {
            if(fileContent.getTextToAnalyse().charAt(i) != ' ') {
                letters.add(Character.toString(fileContent.getTextToAnalyse().charAt(i)));
            }
        }
    }

    public boolean hasNext() {  
        if(index < letters.size()) {
            return true;
        } else {
            return false;
        }
    }

    public String next() {
        if(this.hasNext()) {
            return letters.get(index++);
        } else 
            return null;
    }



}