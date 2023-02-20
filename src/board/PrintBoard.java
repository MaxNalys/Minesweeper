package board;

import game.Minesweeper;

public class PrintBoard {
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void printShowedBoard(Board board) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            System.out.print(ANSI_CYAN + "\t " + i + "" + ANSI_CYAN);
        }
        System.out.println("\n");
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            System.out.print(ANSI_CYAN + "" + i + "\t" + ANSI_CYAN);
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getShowedBoard()[i][j] == 0) {
                    System.out.print(WHITE_BOLD_BRIGHT + " ?\t" + WHITE_BOLD_BRIGHT);
                } else if (board.getShowedBoard()[i][j] == Minesweeper.BOMB_IDENTIFIER) {
                    System.out.print(ANSI_RED + " \uD83D\uDCA3\t" + ANSI_RED);
                } else {
                    System.out.print(ANSI_GREEN + " " + board.getShowedBoard()[i][j] + "\t" + ANSI_GREEN);
                }
            }
            System.out.println();
        }
    }
}
