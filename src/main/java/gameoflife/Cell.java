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

//    public int computeAliveNeighbors() {
//        int aliveNeighbors = 0;
//        for (int i = this.y - 1; i <= this.y + 1; ++i) {
//            for (int j = this.x - 1; j <= this.x + 1; ++j) {
//                if()
//            }
//        }
//    }


    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this.x != ((Cell) obj).getX()) {
            result = false;
        }
        if (this.y != ((Cell) obj).getY()) {
            result = false;
        }
        if (this.cellState != ((Cell) obj).getCellState()) {
            result = false;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
