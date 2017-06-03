package gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peng on 2017/6/3.
 */
public class Plane {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public Cell getCellWithXandY(int x, int y) {
        return cells.get(getIndex(x, y));
    }

    public Cell getCellWithIndex(int index) {
        return cells.get(index);
    }

    private static int getIndex(int x, int y) {
        return y * WIDTH + x;
    }

    public static int getValueWithLowBorder(int value, int lowBorder) {
        if (value < lowBorder) {
            return lowBorder;
        }
        return value;
    }

    public static int getValueWithUpBorder(int value, int upBorder) {
        if (value > upBorder) {
            return upBorder;
        }
        return value;
    }


    //必须根据备份(没变化的)Cells进行判断
    public static int getAliveNeighbors(Cell cell, List<Cell> listCells) {
        int aliveNum = 0;
        int xLeft = getValueWithLowBorder(cell.getX() - 1, 0);
        int xRight = getValueWithUpBorder(cell.getX() + 1, WIDTH - 1);
        int yTop = getValueWithLowBorder(cell.getY() - 1, 0);
        int yBottom = getValueWithUpBorder(cell.getY() + 1, HEIGHT - 1);

        for (int i = xLeft; i <= xRight; ++i) {
            for (int j = yTop; j <= yBottom; ++j) {
                if (i == cell.getX() && j == cell.getY()) {
                    continue;
                }
                if (listCells.get(getIndex(i, j)).getCellState() == CellState.ALIVE) {
                    aliveNum++;
                }
            }
        }
        return aliveNum;
    }

    public void setAliveCells() {
        getCellWithXandY(1, 1).setCellState(CellState.ALIVE);
        getCellWithXandY(2, 1).setCellState(CellState.ALIVE);
        getCellWithXandY(2, 2).setCellState(CellState.ALIVE);
        getCellWithXandY(1, 2).setCellState(CellState.ALIVE);

        getCellWithXandY(2, 7).setCellState(CellState.ALIVE);
        getCellWithXandY(2, 8).setCellState(CellState.ALIVE);
        getCellWithXandY(2, 9).setCellState(CellState.ALIVE);
        getCellWithXandY(2, 10).setCellState(CellState.ALIVE);
    }


    public List<Cell> backUpCurrentCells() {
        List<Cell> list = new ArrayList<>();

        for (int i = 0; i != cells.size(); ++i) {
            Cell item = cells.get(i);
            Cell newCell = new Cell(item.getX(), item.getY(), item.getCellState());
            list.add(newCell);
        }
        return list;
    }


    //输出矩阵形式的存活信息
    public void printCellsStates() {
        for (int i = 0; i != HEIGHT; ++i) {
            for (int j = 0; j != WIDTH; ++j) {
                System.out.print(getCellWithXandY(j, i).getCellState().toString() + "\t");
            }
            System.out.println();
        }
    }


}
