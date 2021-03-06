package gameoflife;

/**
 * Created by Peng on 2017/6/3.
 */
public final class Cell {
    private final int x;
    private final int y;
    private CellState cellState;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellState = CellState.DEAD;
    }


    public Cell(int x, int y, CellState state) {
        this.x = x;
        this.y = y;
        cellState = state;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

}
