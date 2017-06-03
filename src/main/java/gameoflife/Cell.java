package gameoflife;

/**
 * Created by Peng on 2017/6/3.
 */
public final class Cell {
    private final int x;
    private final int y;
    private CellState cellState;

    private Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellState = CellState.DEAD;
    }


    private Cell(int x, int y, CellState state) {
        this.x = x;
        this.y = y;
        cellState = state;
    }

    public static Cell onXAndY(int x, int y) {
        return new Cell(x, y);
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
