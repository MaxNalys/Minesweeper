
public abstract class Cell {
    private CellIdentifier cellIdentifier;
    private boolean isRevealed;

    public Cell(CellIdentifier cellIdentifier, boolean isRevealed) {
        this.cellIdentifier = cellIdentifier;
        this.isRevealed = isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public CellIdentifier getCellIdentifier() {
        return cellIdentifier;
    }

    public void setCellIdentifier(CellIdentifier cellIdentifier) {
        this.cellIdentifier = cellIdentifier;
    }
}
