
public class Board {
    public static final int BOARD_SIZE = 8;
    private final Cell[][] board;

    public Board() {
        this.board = new Cell[BOARD_SIZE][BOARD_SIZE];
    }

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }
}
