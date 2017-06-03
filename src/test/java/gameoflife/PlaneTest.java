package gameoflife;

import java.util.List;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Created by Peng on 2017/6/3.
 */
public class PlaneTest {

    @Test
    public void printCellsStates() throws Exception {
        Plane plane = new Plane();
        plane.setAliveCells();
        plane.printCellsStates();
    }

    @Test
    public void setAliveCells() throws Exception {
        Plane plane = new Plane();
        plane.setAliveCells();
        List<Cell> backUpCells = plane.backUpCurrentCells();

        assertTrue(getAliveNieghborsWithXandY(plane, 1, 1, backUpCells) == 3);
        assertTrue(getAliveNieghborsWithXandY(plane, 1, 2, backUpCells) == 3);
        assertTrue(getAliveNieghborsWithXandY(plane, 2, 1, backUpCells) == 3);
        assertTrue(getAliveNieghborsWithXandY(plane, 2, 2, backUpCells) == 3);


        assertTrue(getAliveNieghborsWithXandY(plane, 2, 7, backUpCells) == 1);
        assertTrue(getAliveNieghborsWithXandY(plane, 2, 8, backUpCells) == 2);
        assertTrue(getAliveNieghborsWithXandY(plane, 2, 9, backUpCells) == 2);
        assertTrue(getAliveNieghborsWithXandY(plane, 2, 10, backUpCells) == 1);

    }

    public int getAliveNieghborsWithXandY(Plane plane, int x, int y, List<Cell> cells) {

        return Plane.getAliveNeighbors(plane.getCellWithXandY(x, y), cells);
    }


    @Test
    public void getCellWithXandY() throws Exception {
        Plane plane = new Plane();
//        assertTrue(plane.getCellWithXandY(10, 10).equals(new Cell(10, 10)));
//        assertTrue(plane.getCellWithXandY(9, 10).equals(new Cell(9, 10)));
//        assertTrue(plane.getCellWithXandY(3, 10).equals(new Cell(3, 10)));
//        assertTrue(plane.getCellWithXandY(9, 8).equals(new Cell(9, 8)));
    }

    @Test
    public void getWidthandHeight() {
        assertTrue(Plane.getHEIGHT() == 40);
        assertTrue(Plane.getWIDTH() == 40);
    }


}
