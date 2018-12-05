import java.util.*;

class Board {
    List<Square> board;

    Board() {
        this.board = new ArrayList<>();
    }

    void setSquares(){
        for(int i = 0; i < 9; i++) {
            board.add(new Square(String.valueOf(i+1)));
        }
    }

}