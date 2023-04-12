import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MineSweeper {
    private final Board board;

    public MineSweeper() {
        this.board = new Board();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        board.initializeBoard();
        generateGame();
        int x, y;
        do {
            PrintBoard.printBoard(board);
            System.out.println("Enter x: ");
            x = scanner.nextInt();
            System.out.println("Enter y: ");
            y = scanner.nextInt();
            openCell(x, y);
            try {
                if (isLose(x, y)) {
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException ignored) {}
        } while (!isWin());
        System.out.println("GAME OVER");
        openAllCells();
        PrintBoard.printBoard(board);
    }

    private boolean isWin() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getBoard()[i][j].isRevealed() && !board.getBoard()[i][j].isBomb()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLose(int x, int y) {
        return board.getBoard()[x][y].isBomb();

    }

    private void openCell(int x, int y) {
        try {
            board.getBoard()[x][y].setRevealed(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input");
        }
    }


    private void openAllCells() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                board.getBoard()[i][j].setRevealed(true);
            }
        }
    }

    private void generateGame() {
        generateBombs();
        setBombCounters();
    }

    private void generateBombs() {
        ArrayList<Integer> integerArrayList = new ArrayList<>(16);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                integerArrayList.add(j);
            }
        }
        Collections.shuffle(integerArrayList);
        for (int i = 0; i < 10; i++) {
            board.getBoard()[integerArrayList.get(i)][integerArrayList.get(i + 1)].setBomb(true);
            board.getBoard()[integerArrayList.get(i)][integerArrayList.get(i + 1)].setEmpty(false);
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
        } if (isSouthDirection(x, y)) {
            count++;
        }  if (isEastDirection(x, y)) {
            count++;
        }  if (isWestDirection(x, y)) {
            count++;
        }  if (isNorthEastDirection(x, y)) {
            count++;
        }  if (isNorthWestDirection(x, y)) {
            count++;
        }  if (isSouthWestDirection(x, y)) {
            count++;
        }  if (isSouthEastDirection(x, y)) {
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
        if (isWithinBounds(x - 1, y)) {
            return board.getBoard()[x - 1][y].isBomb();
        }
        return false;
    }

    private boolean isSouthDirection(int x, int y) {
        if (isWithinBounds(x + 1, y)) {
            return board.getBoard()[x + 1][y].isBomb();
        }
        return false;
    }


    private boolean isEastDirection(int x, int y) {
        if (isWithinBounds(x, y + 1)) {
            return board.getBoard()[x][y + 1].isBomb();
        }
        return false;
    }

    private boolean isWestDirection(int x, int y) {
        if (isWithinBounds(x, y - 1)) {
            return board.getBoard()[x][y - 1].isBomb();
        }
        return false;
    }


    private boolean isNorthEastDirection(int x, int y) {
        if (isWithinBounds(x - 1, y + 1)) {
            return board.getBoard()[x - 1][y + 1].isBomb();
        }
        return false;

    }

    private boolean isNorthWestDirection(int x, int y) {
        if (isWithinBounds(x - 1, y - 1)) {
            return board.getBoard()[x - 1][y - 1].isBomb();
        }
        return false;
    }

    private boolean isSouthEastDirection(int x, int y) {
        if (isWithinBounds(x + 1, y + 1)) {
            return board.getBoard()[x + 1][y + 1].isBomb();
        }
        return false;
    }

    private boolean isSouthWestDirection(int x, int y) {
        if (isWithinBounds(x + 1, y - 1)) {
            return board.getBoard()[x + 1][y - 1].isBomb();
        }
        return false;
    }
}
