package gameoflife;

import java.util.List;

/**
 * Created by Peng on 2017/6/3.
 */
public class Generation {

    private Plane plane;

    public Generation(Plane plane) {
        this.plane = plane;
    }


    public boolean updateCellsState() {

        List<Cell> cellsBackUp = plane.backUpCurrentCells();

        for (int i = 0; i != cellsBackUp.size(); ++i) {
            Cell currentCell = plane.getCellWithIndex(i);
            Cell oldCell = cellsBackUp.get(i);
            int neighborCount = Plane.getAliveNeighbors(oldCell, cellsBackUp);
            CellState nextState = Rule.getNextStateByRule(oldCell.getCellState(), neighborCount);
            currentCell.setCellState(nextState);
        }
        if (checkStopUpdate(cellsBackUp, plane.backUpCurrentCells())) {
            return false;
        }

        return true;


    }

    //停止进化了
    public static boolean checkStopUpdate(List<Cell> oldCells, List<Cell> newCells) {
        boolean result = true;
        if (oldCells.size() != newCells.size()) {
            result = false;
        }
        for (int i = 0; i != oldCells.size(); ++i) {
            if (!checkCellEqual(oldCells.get(i), newCells.get(i))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkCellEqual(Cell cell1, Cell cell2) {
        boolean result = true;
        if (cell1.getX() != cell2.getX()) {
            result = false;
        }
        if (cell1.getY() != cell2.getY()) {
            result = false;
        }
        if (cell1.getCellState() != cell2.getCellState()) {
            result = false;
        }
        return result;
    }




}
