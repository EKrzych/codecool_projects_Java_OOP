import java.util.Iterator;
import java.util.*;

class StatisticalAnalysis {
    Iterator<String> iterator;

    StatisticalAnalysis(Iterator<String> iter) {
        iterator = iter;
    }

    int countOf(String ... elements) {
        int counter = 0;
        while(iterator.hasNext()){
            if(Arrays.asList(elements).contains(iterator.next())) {
                counter++;
            }
        }
        return counter;
    }

    int dictionarySize(){
        HashSet<String> analysis = new HashSet<String>();
            
        while(iterator.hasNext()){
            analysis.add(iterator.next());         
        }
        return analysis.size();
    }

    int size() {
        int counter = 0;
        while(iterator.hasNext()){
            iterator.next();
            counter++;
        }
        return counter;
    }

    Set<String> occurMoreThan(Integer occurence) {
        HashMap<String,Integer> analysis = new HashMap<String,Integer>();
        Set<String> wordSet = new HashSet<String>();
            
        while(iterator.hasNext()){
            String key = iterator.next();
            analysis.put(key, analysis.getOrDefault(key, 0)+1);  
        }

        for(Map.Entry<String, Integer> entry : analysis.entrySet()) {
            if((int)entry.getValue() > occurence) {
                wordSet.add(entry.getKey());
            } 
        }
        return wordSet;
    }

    HashMap<String, Float> letterOccurence() {
        HashMap<String,Float> analysis = new HashMap<String,Float>();
        int counter = 0;
            
        while(iterator.hasNext()){
            String key = iterator.next();
            analysis.put(key, analysis.getOrDefault(key, 0f)+1);
            counter++;  
        }
        for(Map.Entry<String, Float> entry : analysis.entrySet()) {
            analysis.put(entry.getKey(), (entry.getValue()/counter*100f));
            } 

        return analysis;
    }

    
}