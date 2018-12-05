import java.util.*;

class View {
    void printBoard(Board list) {
        for(int i = 0; i < 9; i++) {
            if(i == 2 ||i == 5 || i == 8) {
                System.out.println(list.board.get(i).status);
            } else {
                System.out.print(list.board.get(i).status);
            }
        
        }
    }

    public void printLine(String message) {
        System.out.println(message);
    }
}