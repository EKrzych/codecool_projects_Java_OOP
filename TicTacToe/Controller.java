import java.util.*;

class Controller {

    public static int askUser(String message, View view) {
        view.printLine(message);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    public static void main(String[] args) {
        View view = new View();
        Board board = new Board();
        board.setSquares();
        view.printBoard(board);
        int userInput = askUser("Please provide number (1-9)", view);
        board.board.get(userInput-1).changeStatusX();
        view.printBoard(board);

    }
}