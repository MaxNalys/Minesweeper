package game;

import board.Board;
import board.PrintBoard;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    public static final int BOMB_IDENTIFIER = 10;
    private Board board;

    public Minesweeper() {
        this.board = new Board();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        PrintBoard.printShowedBoard(board);
        int x;
        int y;
        setBombsToArray();
        fillArray();
        while (!isGameOver()) {
            System.out.println("Enter x: ");
            x = scanner.nextInt();
            System.out.println("Enter y: ");
            y = scanner.nextInt();
            openNumber(x, y);
            PrintBoard.printShowedBoard(board);
            if (isBomb(x, y)) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }

    private void setBombsToArray() {
        Random random = new Random();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            board.getHiddenBoard()[random.nextInt(Board.BOARD_SIZE)][random.nextInt(Board.BOARD_SIZE)] = BOMB_IDENTIFIER;
        }
    }

    private void fillArray() {
        Random random = new Random();
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getHiddenBoard()[i][j] != BOMB_IDENTIFIER) {
                    board.getHiddenBoard()[i][j] = random.nextInt(BOMB_IDENTIFIER) + 1;
                }
            }
        }
    }

    private void openNumber(int x, int y) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getHiddenBoard()[i][j] == board.getNumberFromHiddenBoard(x, y)) {
                    board.getShowedBoard()[i][j] = board.getNumberFromHiddenBoard(x, y);
                }
            }
        }
    }

    private boolean isBomb(int x, int y) {
        return board.getNumberFromHiddenBoard(x, y) == BOMB_IDENTIFIER;
    }

    private boolean isGameOver() {
        return isAllNumbersAreGuessed();
    }

    private boolean isAllNumbersAreGuessed() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getShowedBoard()[i][j] == 0 && board.getNumberFromHiddenBoard(i, j) != BOMB_IDENTIFIER) {
                    return false;
                }
            }
        }
        return true;
    }
}
