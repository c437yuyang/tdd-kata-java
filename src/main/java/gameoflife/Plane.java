package gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peng on 2017/6/3.
 */
public class Plane {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private List<Cell> cells = new ArrayList<>();

    public Plane() {
        initCells();
    }

    private void initCells() {
        for (int i = 0; i != HEIGHT; ++i) {
            for (int j = 0; j != WIDTH; ++j) {
                cells.add(new Cell(j, i));
            }
        }
    }


    public Cell getCellWithXandY(int x, int y) {
        return cells.get(getIndex(x, y));
    }

    private int getIndex(int x, int y) {
        return y * WIDTH + x;
    }


    public int getAliveNeighbors(Cell cell) {
        int aliveNum = 0;

        int xLeft = cell.getX() - 1 < 0 ? 0 : cell.getX() - 1;
        int xRight = cell.getX() + 1 > WIDTH - 1 ? WIDTH - 1 : cell.getX() + 1;
        int yTop = cell.getY() - 1 < 0 ? 0 : cell.getY() - 1;
        int yBottom = cell.getY() + 1 > HEIGHT - 1 ? HEIGHT - 1 : cell.getY() + 1;


        for (int i = xLeft; i <= xRight; ++i) {
            for (int j = yBottom; j <= yTop; ++j) {
                if (i == cell.getX() && j == cell.getY()) {
                    continue;
                }
                if (cells.get(getIndex(i, j)).getCellState() == CellState.ALIVE) {
                    aliveNum++;
                }
            }
        }
        return aliveNum;
    }

    public void setAliveCells() {
        getCellWithXandY(1,1).setCellState(CellState.ALIVE);
        getCellWithXandY(2,1).setCellState(CellState.ALIVE);
        getCellWithXandY(2,2).setCellState(CellState.ALIVE);
        getCellWithXandY(1,2).setCellState(CellState.ALIVE);
    }


}
