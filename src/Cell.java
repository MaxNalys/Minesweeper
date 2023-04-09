
public class Cell {
    private boolean isRevealed;
    private boolean isEmpty;
    private boolean isBomb;
    private int counter;

    public Cell() {
        this.isEmpty = true;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }


    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isRevealed() {
        return isRevealed;
    }
}
