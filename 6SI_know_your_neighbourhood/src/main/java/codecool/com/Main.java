package codecool.com;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        District district = fileReader.readFromFile("malopolska.csv");
        Controller controller = new Controller(district);
        controller.interact();
    }
}

