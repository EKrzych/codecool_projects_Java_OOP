import java.io.*;
import java.util.*;

class FileContent implements IterableText{
    private String fileName;
    private String textToAnalyse;

    FileContent(String s) {
        fileName = s;
        textToAnalyse = createTextToAnalyse(fileName);
    }

    private String createTextToAnalyse(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder textToAnalyse = new StringBuilder();
            String line = br.readLine();

            while(line != null) {
                textToAnalyse.append(line.toLowerCase());
                textToAnalyse.append(" ");
                line = br.readLine();
                
            }
            return textToAnalyse.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return textToAnalyse.toString();
    }

    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }
    
    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }

    String getFilename() {
        return fileName;
    }

    String getTextToAnalyse() {
        return textToAnalyse;
    }
    
}