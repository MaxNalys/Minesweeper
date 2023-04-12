public class PrintBoard {
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void printBoard(Board board) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            System.out.print(ANSI_CYAN + "\t " + i + "" + ANSI_CYAN);
        }
        System.out.println("\n");
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            System.out.print(ANSI_CYAN + "" + i + "\t" + ANSI_CYAN);
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (!board.getBoard()[i][j].isRevealed()) {
                    System.out.print(WHITE_BOLD_BRIGHT + "■\t" + WHITE_BOLD_BRIGHT);
                } else if (board.getBoard()[i][j].isBomb()) {
                    System.out.print(ANSI_RED + "\uD83D\uDCA3\t" + ANSI_RED);
                } else if ((board.getBoard()[i][j].getCounter() > 0)) {
                    System.out.print(WHITE_BOLD_BRIGHT +  board.getBoard()[i][j].getCounter() + "\t" + WHITE_BOLD_BRIGHT);
                } else {
                    System.out.print(WHITE_BOLD_BRIGHT + "□" + "\t" + WHITE_BOLD_BRIGHT);
                }
            }
            System.out.println();
        }
    }
}
