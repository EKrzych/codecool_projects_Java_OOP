import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Main {

    private String askUser(String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void printMenu() {
        String [] menu = { "1. See a list TODO items",
                            "2. Add new task", 
                            "3. Mark Done task",
                            "4. Unmark task",
                            "5. Remove task",
                            "6. Archive all done task",
                            "7. Quit"
                            };
        for (String e : menu){
            System.out.println(e);
        }
    }

    public LocalDate getDeadline(){
        LocalDate deadline = null;
        String month = this.askUser("Accomplished till: month(number): ");
        String day = this.askUser("Accomplished till: day(number): ");
        month = (month.length() == 1 ? "0" + month : month);
        day = (day.length() == 1 ? "0" + day : day);
        String date = "2018-" + month + "-" + day;
        try{
            deadline = LocalDate.parse(date);
        } catch (java.time.format.DateTimeParseException e1){
            System.err.println("Date was incorrect.");
        }
        return deadline;
    }

    private void displayMatrix(TodoMatrix myMatrix) {
        String choice = this.askUser("What would you like to see: IU, IN, NU, NN, ALL?");
            switch (choice){
                case "all": case "ALL" :
                    System.out.println(myMatrix);
                    break;
                case "IU": case "IN": case "NU": case "NN":
                    System.out.println(myMatrix.getQuarter(choice));
                    break;
                default:
                    System.out.println("Ther's no such option");
            }
    }

    private void addNewTask(TodoMatrix myMatrix) {
        String title = this.askUser("What is your task?");
        String importance = this.askUser("Is it important(yes/no)");
        boolean isImportant = (importance.equals("yes") ? true : false);
        LocalDate deadline = this.getDeadline();
        try {
            myMatrix.addItem(title, deadline, isImportant);
        } catch (NullPointerException e1) {
            System.err.println("Task data were unsufficient.");
        }
    }

    private void markDone(TodoMatrix myMatrix) {
        String choice = this.askUser("Which would you like to display: IU, IN, NU, NN");
        try{
            System.out.println(myMatrix.getQuarter(choice));
            Integer index = Integer.parseInt(this.askUser("Which would you like mark done?"));
            myMatrix.getQuarter(choice).getItem(index-1).mark();
        } catch (java.lang.NumberFormatException e1){
            System.err.println("You need to give number.");
        } catch (java.lang.IndexOutOfBoundsException e2) {
            System.err.println("There's no such task");
        }
    }

    private void markUnDone(TodoMatrix myMatrix) {
        String choice = this.askUser("Which would you like to display: IU, IN, NU, NN");
        try{
            System.out.println(myMatrix.getQuarter(choice));
            Integer index = Integer.parseInt(this.askUser("Which would you like unmark?"));
            myMatrix.getQuarter(choice).getItem(index-1).unmark();
        } catch (java.lang.NumberFormatException e1){
            System.err.println("You need to give number.");
        } catch (java.lang.IndexOutOfBoundsException e2) {
            System.err.println("There's no such task");
        }
    }

     private void removeTask(TodoMatrix myMatrix) {
        String choice = this.askUser("Which would you like to display: IU, IN, NU, NN");
        try {
            System.out.println(myMatrix.getQuarter(choice));
            Integer index = Integer.parseInt(this.askUser("Which would you like remove?(number)"));
            myMatrix.getQuarter(choice).removeItem(index-1);
        } catch (java.lang.NumberFormatException e1){
            System.err.println("You need to give number.");
        } catch (java.lang.IndexOutOfBoundsException e2) {
            System.err.println("There's no such task");
        }
    }

    public static void main (String [] args) {
        Main newVisit = new Main();
        TodoMatrix myMatrix = new TodoMatrix();
        String fileName = "myTodoList.csv";
        myMatrix.addItemsFromFile(fileName);
        String option;
        do {
            newVisit.printMenu();
            option= newVisit.askUser("What would you like to do(choose number)");
            switch (option) {
                case "1":
                    newVisit.displayMatrix(myMatrix);
                break;
                case "2":
                    newVisit.addNewTask(myMatrix);
                break;
                case "3":
                    newVisit.markDone(myMatrix);
                break;
                case "4":
                    newVisit.markUnDone(myMatrix);
                break;
                case "5":
                    newVisit.removeTask(myMatrix);
                break;
                case "6":
                    myMatrix.archiveItems();
                break;
            }
        }while(!option.equals("7"));

        myMatrix.archiveItems();
        myMatrix.saveItemsToFile(fileName);

    }
}