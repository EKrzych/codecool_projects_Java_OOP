import java.util.*;

class View {
    static void print(LinkedHashMap<String,Integer> analysis) {
        for(Map.Entry<String, Integer> entry : analysis.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
    static void print(String string) {
        System.out.println("==" + string + "==");    
    }

    static void print(HashMap<String, Float> letterOccurence) {
        for(Map.Entry<String, Float> entry : letterOccurence.entrySet()) {
            System.out.print("[" + entry.getKey().toUpperCase() + " -> " + String.format("%.2f", entry.getValue()) + "] ");
            } 
        System.out.println();
    }
    static void print(long start, long end) {
        String startUnderScore = "\033[4m";
        String endUnderScore = "\033[0m";
        System.out.println(startUnderScore + "Benchmark time: " + String.format("%.2f",((end - start)/1000f)) + "sec" + endUnderScore);
    }
}