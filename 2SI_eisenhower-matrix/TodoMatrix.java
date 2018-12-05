import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.*;
import java.util.ArrayList;
import java.text.*;
import java.util.Collections;



class TodoMatrix {
    Map<String, TodoQuarter> todoQuarters = new HashMap<String, TodoQuarter>();

    public TodoMatrix() {
        this.todoQuarters.put("IU", new TodoQuarter());
        this.todoQuarters.put("IN", new TodoQuarter());
        this.todoQuarters.put("NU", new TodoQuarter());
        this.todoQuarters.put("NN", new TodoQuarter());
    }

    public TodoQuarter getQuarter(String status) {
        return this.todoQuarters.get(status);
    }

    public void addItem(String title, LocalDate deadline, boolean isImportant) {
        String key = new Key(deadline, isImportant).getKey();
        this.todoQuarters.get(key).addItem(title, deadline);
    }

    public void addItem(String title, LocalDate deadline) {
        this.addItem(title, deadline, false); 
    }

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

    public void addItemsFromFile(String fileName) {
       String[] todoListFromFile = readArray(fileName);
       String [] tempArr;
       String [] dayMonth;
       LocalDate deadline;

       for (String element : todoListFromFile) {
            tempArr = element.split("\\|");
            dayMonth = tempArr[1].split("-");
            deadline = LocalDate.parse("2018-" + dayMonth[1] + "-" + dayMonth[0]);
            boolean isImportant = (tempArr.length > 2 ? true : false);

            this.addItem(tempArr[0], deadline, isImportant);
       }
    }

    public void archiveItems() {
        for (Map.Entry<String, TodoQuarter> entry : this.todoQuarters.entrySet()) {
            entry.getValue().archiveItems();
        }
    }

    public String toString() {
        String formattedList = "";
        for (Map.Entry<String, TodoQuarter> entry : todoQuarters.entrySet()) {
            formattedList += entry.getKey() + "\n";
            formattedList += entry.getValue() + "\n";  
        }
        return formattedList;
    }

     public void saveItemsToFile(String fileName) {
        TodoMatrixFileFormatter fileFormatter = new TodoMatrixFileFormatter(this);
        try (FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)) {
            out.print(fileFormatter.todoMatrixString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TodoMatrix myMatrix = new TodoMatrix();
        String fileName = "myTodoList.csv";
        myMatrix.addItemsFromFile(fileName);
        String date = "2018-03-09";
        LocalDate deadline = LocalDate.parse(date);
        myMatrix.addItem("testy", deadline, true);
        myMatrix.saveItemsToFile(fileName);
        System.out.println(myMatrix);
        
    }
}

class TodoMatrixFileFormatter {
    String todoMatrixString = "";

    public TodoMatrixFileFormatter (TodoMatrix myMatrix) {
        for (Map.Entry<String, TodoQuarter> entry : myMatrix.todoQuarters.entrySet()) {
            TodoQuarter quarter = entry.getValue();

            for (int i = 0; i < quarter.getSize(); i++) {
                TodoItem item = quarter.getItem(i);
                String title = item.title;
                LocalDate date = item.deadline;
                String deadline = TodoItem.changeDateToString(date);
                this.todoMatrixString += title + "|" + deadline + "|";

                if (entry.getKey().contains("I")) {
                    this.todoMatrixString += "isImportant";
                }
                this.todoMatrixString += "\n";
            }
        }
    }
}

class Key {
    boolean isImportant = false;
    LocalDate deadline = null;
    boolean isUrgent = false;

    private boolean checkIfUrgent(LocalDate deadline) {     
        if (ChronoUnit.DAYS.between(LocalDate.now(), deadline) <= 3) {
            return true;
        }
        return false;
    }

    public String getKey() {
        String firstLetter = (isImportant ? "I" : "N");
        String secondLetter = (isUrgent ? "U" : "N");
        return firstLetter + secondLetter;
    }

    public Key(LocalDate deadline, boolean isImportant) {
        this.deadline = deadline;
        this.isImportant = isImportant;
        this.isUrgent = checkIfUrgent(deadline);
    }
}