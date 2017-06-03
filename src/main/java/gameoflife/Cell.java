package gameoflife;

/**
 * Created by Peng on 2017/6/3.
 */
public class Cell {

    public enum State { ALIVE, DEAD };
    private final int x;
    private final int y;
    private State cellState;

    private Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellState = State.DEAD;
    }

    private Cell(int x, int y,State state) {
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

    public State getCellState() {
        return cellState;
    }

    public void setCellState(State cellState) {
        this.cellState = cellState;
    }
}
