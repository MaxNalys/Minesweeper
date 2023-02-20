package board;

public class Board {
    public static final int BOARD_SIZE = 9;
    private int[][] hiddenBoard;
    private int[][] showedBoard;

    public Board() {
        this.hiddenBoard = new int[BOARD_SIZE][BOARD_SIZE];
        this.showedBoard = new int[BOARD_SIZE][BOARD_SIZE];
    }

    public int[][] getHiddenBoard() {
        return hiddenBoard;
    }

    public int[][] getShowedBoard() {
        return showedBoard;
    }

    public int getNumberFromHiddenBoard(int x, int y) {
        try {
            return hiddenBoard[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error");
            return 10;
        }
    }
}
