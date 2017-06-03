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


    public void updateCellsState() {

        List<Cell> cellsBackUp = plane.backUpCurrentCells();

        for (int i = 0; i != cellsBackUp.size(); ++i) {
            Cell currentCell = plane.getCellWithIndex(i);
            Cell oldCell = cellsBackUp.get(i);
            int neighborCount = Plane.getAliveNeighbors(oldCell, cellsBackUp);
            CellState nextState = Rule.getNextStateByRule(oldCell.getCellState(), neighborCount);
            currentCell.setCellState(nextState);
        }
    }




}
