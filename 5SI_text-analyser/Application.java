import java.util.*;

public class Application {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(String fileName : args) {
            
            LinkedHashMap<String,Integer> analysis = new LinkedHashMap<String,Integer>();
            FileContent fileContent = new FileContent(fileName);
            StatisticalAnalysis researchChar = new StatisticalAnalysis(fileContent.charIterator());     
            StatisticalAnalysis researchWord = new StatisticalAnalysis(fileContent.wordIterator());
            
            
            analysis.put("Char count: ", researchChar.size());
            analysis.put("Word count: ", researchWord.size());
            researchWord.iterator = fileContent.wordIterator();
            analysis.put("Dict size: ", researchWord.dictionarySize());
            researchWord.iterator = fileContent.wordIterator();
            
            analysis.put("'love' count: ", researchWord.countOf("love"));
            researchWord.iterator = fileContent.wordIterator();
            analysis.put("'hate' count: ", researchWord.countOf("hate"));
            researchWord.iterator = fileContent.wordIterator();
            analysis.put("'music' count: ", researchWord.countOf("music"));
            
            float allLetters = analysis.get("Char count: ");
            researchChar.iterator = fileContent.charIterator();
            float volwes = researchChar.countOf("a", "o", "i", "u", "e"); 
            analysis.put("vowels %: ", (Integer)((int)(volwes/allLetters*100)));

            View.print(fileContent.getFilename());
            View.print(analysis);

            researchChar.iterator = fileContent.charIterator();
            float a = researchChar.countOf("a");
            researchChar.iterator = fileContent.charIterator();
            float e = researchChar.countOf("e");
            System.out.println("'a:e count ratio' : " + String.format("%.2f", a/e));
            
            researchWord.iterator = fileContent.wordIterator();
            System.out.println("Most used words (>1%): " + researchWord.occurMoreThan(analysis.get("Word count: ")/100));
            
            researchChar.iterator = fileContent.charIterator();
            View.print(researchChar.letterOccurence());
            
        }
        Long end = System.currentTimeMillis();
        View.print(start, end);  
    }
}