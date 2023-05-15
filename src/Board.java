import java.util.ArrayList;
import java.util.Collections;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final Cell[][] board;

    public Board() {
        this.board = new Cell[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new EmptyCell(CellIdentifier.EMPTY_CELL);
            }
        }
        generateBombCells();
        setBombCounterCells();

    }

    private void generateBombCells() {
        ArrayList<Integer> integerArrayList = new ArrayList<>(16);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                integerArrayList.add(j);
            }
        }
        Collections.shuffle(integerArrayList);
        for (int i = 0; i < 10; i++) {
            board[integerArrayList.get(i)][integerArrayList.get(i + 1)] = new BombCell(CellIdentifier.BOMB_CELL);
        }
    }

    private void setBombCounterCells() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (!board[i][j].getCellIdentifier().equals(CellIdentifier.BOMB_CELL)) {
                    if (determineCountOfBombsForOneCell(i, j) > 0) {
                        board[i][j] = new BombCounterCell(CellIdentifier.BOMB_COUNTER);
                        BombCounterCell bombCounterCell = (BombCounterCell) board[i][j];
                        bombCounterCell.setCounter(determineCountOfBombsForOneCell(i, j));
                    }
                }
            }
        }
    }

    private int determineCountOfBombsForOneCell(int x, int y) {
        int count = 0;
        if (isNorthDirection(x, y)) {
            count++;
        }
        if (isSouthDirection(x, y)) {
            count++;
        }
        if (isEastDirection(x, y)) {
            count++;
        }
        if (isWestDirection(x, y)) {
            count++;
        }
        if (isNorthEastDirection(x, y)) {
            count++;
        }
        if (isNorthWestDirection(x, y)) {
            count++;
        }
        if (isSouthWestDirection(x, y)) {
            count++;
        }
        if (isSouthEastDirection(x, y)) {
            count++;
        }
        return count;
    }

    private boolean isWithinBounds(int x, int y) {
        return x < Board.BOARD_SIZE && x >= 0 && y < Board.BOARD_SIZE && y >= 0;
    }

    private boolean isNorthDirection(int x, int y) {
        if (isWithinBounds(x - 1, y)) {
            return board[x - 1][y].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }

    private boolean isSouthDirection(int x, int y) {
        if (isWithinBounds(x + 1, y)) {
            return board[x + 1][y].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }

    private boolean isEastDirection(int x, int y) {
        if (isWithinBounds(x, y + 1)) {
            return board[x][y + 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }

    private boolean isWestDirection(int x, int y) {
        if (isWithinBounds(x, y - 1)) {
            return board[x][y - 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }


    private boolean isNorthEastDirection(int x, int y) {
        if (isWithinBounds(x - 1, y + 1)) {
            return board[x - 1][y + 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;

    }

    private boolean isNorthWestDirection(int x, int y) {
        if (isWithinBounds(x - 1, y - 1)) {
            return board[x - 1][y - 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }

    private boolean isSouthEastDirection(int x, int y) {
        if (isWithinBounds(x + 1, y + 1)) {
            return board[x + 1][y + 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }

    private boolean isSouthWestDirection(int x, int y) {
        if (isWithinBounds(x + 1, y - 1)) {
            return board[x + 1][y - 1].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);
        }
        return false;
    }
}
