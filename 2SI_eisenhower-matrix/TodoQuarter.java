import java.util.*;
import java.util.Collections;
import java.time.LocalDate;

class TodoQuarter {
    List <TodoItem> todoItems = new ArrayList <TodoItem> ();

    public TodoQuarter() {  
    }
    
    public void addItem(String title, LocalDate deadline) {
        todoItems.add(new TodoItem(title, deadline));
        Collections.sort(todoItems);
    }

    public void removeItem(int index) {
        this.todoItems.remove(index);
    }

    public void archiveItems() {
        Iterator<TodoItem> iter = this.todoItems.iterator();
        while(iter.hasNext()) {
            TodoItem element = iter.next();
            if (element.isDone.equals(true)){
                iter.remove();
            }
        }
    }

    public Integer getSize() {
        return todoItems.size();
    }

    public TodoItem getItem(int index) {
        return this.todoItems.get(index);
    }

    public String toString() {
        String formattedList = "";
        for (int i = 0; i<this.todoItems.size(); i++) {
            formattedList += ((i+1) + ". " + this.todoItems.get(i) + "\n");
        }
        return formattedList;
    }

    public static void main (String [] args) {
        TodoQuarter ig = new TodoQuarter();
        String date = "2016-12-14";
        LocalDate changedDate = LocalDate.parse(date);
        ig.addItem("Wow", changedDate);
        date = "2016-02-01";
        changedDate = LocalDate.parse(date);
        ig.addItem("Ola", changedDate);
        System.out.println(ig);
        //ig.removeItem(2);
        ig.archiveItems();
        System.out.println("Po usunieciu");
        System.out.println(ig);

        
        
    }
}