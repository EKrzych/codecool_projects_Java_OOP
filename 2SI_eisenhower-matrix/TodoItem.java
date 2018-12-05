import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

class TodoItem implements Comparable<TodoItem> {
    String title = null;
    LocalDate deadline = null;
    Boolean isDone = false;

    public TodoItem(String title, LocalDate deadline) {
        this.title = title;
        this.deadline = deadline;
    }
    public void mark () {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public static String changeDateToString(LocalDate deadline) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        return deadline.format(formatter);
    }

    public String toString() {
        if (isDone) {
            return "[x] " + changeDateToString(deadline) + " " + title;
        } else {
            return "[ ] " + changeDateToString(deadline) + " " + title;
        }
    }

    public int compareTo(TodoItem object) {
        return this.deadline.compareTo(object.deadline);
    }
    
    public static void main (String [] args) {
        String date = "2016-" + "08-16";
        LocalDate changedDate = LocalDate.parse(date);
        System.out.println(new TodoItem("Cokolwiek", changedDate));
    }
}