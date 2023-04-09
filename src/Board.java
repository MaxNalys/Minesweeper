
public class Board {
    public static final int BOARD_SIZE = 8;
    private final Cell[][] board;

    public Board() {
        this.board = new Cell[BOARD_SIZE][BOARD_SIZE];
    }

    public Cell[][] getBoard() {
        return board;
    }
}
