public class BombCounterCell extends Cell {
    private int counter;

    public BombCounterCell(CellIdentifier cellIdentifier) {
        super(cellIdentifier, false);
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}
