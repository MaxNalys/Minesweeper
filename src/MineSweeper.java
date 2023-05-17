import java.util.Scanner;

public class MineSweeper {
    private final Board board;

    public MineSweeper() {
        this.board = new Board();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
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
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        } while (!isWin());
        System.out.println("GAME OVER");
        openAllCells();
        PrintBoard.printBoard(board);
    }

    private boolean isWin() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.getBoard()[i][j].isRevealed() && !board.getBoard()[i][j].getCellIdentifier().equals(CellIdentifier.BOMB_CELL)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isLose(int x, int y) {
        return board.getBoard()[x][y].getCellIdentifier().equals(CellIdentifier.BOMB_CELL);

    }

    private void openCell(int x, int y) {
        try {
            if (board.getBoard()[x][y].getCellIdentifier().equals(CellIdentifier.EMPTY_CELL)) {
                openEmptyCells(x, y);
            } else {
                board.getBoard()[x][y].setRevealed(true);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input");
        }
    }

    private void openEmptyCells(int x, int y) {
        int xCoordinate = x;
        int yCoordinate = y;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate--;
        }
        xCoordinate = x;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate++;
        }
        xCoordinate = x;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            yCoordinate++;

        }
        yCoordinate = y;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            yCoordinate--;
            if (isWithinBounds(xCoordinate, yCoordinate)) {
                openCell(xCoordinate, yCoordinate);
            }
        }
        yCoordinate = y;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate--;
            yCoordinate++;
            if (isWithinBounds(xCoordinate, yCoordinate)) {
                openCell(xCoordinate, yCoordinate);
            }
        }
        xCoordinate = x;
        yCoordinate = y;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate--;
            yCoordinate--;
        }
        xCoordinate = x;
        yCoordinate = y;
        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate++;
            yCoordinate++;
        }
        xCoordinate = x;
        yCoordinate = y;

        while (isWithinBounds(xCoordinate, yCoordinate)) {
            board.getBoard()[xCoordinate][yCoordinate].setRevealed(true);
            if (board.getBoard()[xCoordinate][yCoordinate].getCellIdentifier().equals(CellIdentifier.BOMB_COUNTER)) {
                break;
            }
            xCoordinate++;
            yCoordinate--;
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x < Board.BOARD_SIZE && x >= 0 && y < Board.BOARD_SIZE && y >= 0;
    }

    private void openAllCells() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                board.getBoard()[i][j].setRevealed(true);
            }
        }
    }
}
