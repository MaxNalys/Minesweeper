import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MineSweeper {
    private final Board board;

    public MineSweeper() {
        this.board = new Board();
    }

    public void startGame() {
        generateGame();
        PrintBoard.printBoard(board);
    }

    private void generateGame() {
        generateBombs();
        setBombCounters();
    }

    private void generateBombs() {
        ArrayList<Integer> integerArrayList = new ArrayList<>(16);
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < Board.BOARD_SIZE; i++) {
                integerArrayList.add(i);
            }
        }
        Collections.shuffle(integerArrayList);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            board.getBoard()[integerArrayList.get(0)][integerArrayList.get(1)].setBomb(true);
            board.getBoard()[integerArrayList.get(0)][integerArrayList.get(1)].setEmpty(false);
            integerArrayList.remove(0);
            integerArrayList.remove(1);
        }
    }

    private void setBombCounters() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (!isBombHere(i, j)) {
                    if (determineCountOfBombsForOneCell(i, j) > 0) {
                        board.getBoard()[i][j].setCounter(determineCountOfBombsForOneCell(i, j));
                        board.getBoard()[i][j].setEmpty(false);
                    }
                }
            }
        }
    }

    private int determineCountOfBombsForOneCell(int x, int y) {
        int count = 0;
        if (isNorthDirection(x, y)) {
            count++;
        } else if (isSouthDirection(x, y)) {
            count++;
        } else if (isEastDirection(x, y)) {
            count++;
        } else if (isWestDirection(x, y)) {
            count++;
        } else if (isNorthEastDirection(x, y)) {
            count++;
        } else if (isNorthWestDirection(x, y)) {
            count++;
        } else if (isSouthWestDirection(x, y)) {
            count++;
        } else if (isSouthEastDirection(x, y)) {
            count++;
        }
        return count;
    }

    private boolean isWithinBounds(int x, int y) {
        return x < Board.BOARD_SIZE && x >= 0 && y < Board.BOARD_SIZE && y >= 0;
    }

    private boolean isBombHere(int x, int y) {
        return board.getBoard()[x][y].isBomb();
    }

    private boolean isNorthDirection(int x, int y) {
        return board.getBoard()[x - 1][y].isBomb() && isWithinBounds(x, y);
    }

    private boolean isSouthDirection(int x, int y) {
        return board.getBoard()[x + 1][y].isBomb() && isWithinBounds(x, y);
    }

    private boolean isEastDirection(int x, int y) {
        return board.getBoard()[x][y + 1].isBomb() && isWithinBounds(x, y);
    }

    private boolean isWestDirection(int x, int y) {
        return board.getBoard()[x][y - 1].isBomb() && isWithinBounds(x, y);
    }

    private boolean isNorthEastDirection(int x, int y) {
        return board.getBoard()[x - 1][y + 1].isBomb() && isWithinBounds(x, y);
    }

    private boolean isNorthWestDirection(int x, int y) {
        return board.getBoard()[x - 1][y - 1].isBomb() && isWithinBounds(x, y);
    }

    private boolean isSouthEastDirection(int x, int y) {
        return board.getBoard()[x + 1][y + 1].isBomb() && isWithinBounds(x, y);
    }

    private boolean isSouthWestDirection(int x, int y) {
        return board.getBoard()[x + 1][y - 1].isBomb() && isWithinBounds(x, y);
    }

}
