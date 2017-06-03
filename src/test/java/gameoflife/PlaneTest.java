package gameoflife;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by Peng on 2017/6/3.
 */
public class PlaneTest {
    @Test
    public void setAliveCells() throws Exception {
        Plane plane = new Plane();
        plane.setAliveCells();

        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(1, 1)) == 3);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(1, 2)) == 3);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 2)) == 3);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 1)) == 3);

        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 7)) == 1);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 8)) == 2);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 9)) == 2);
        assertTrue(plane.getAliveNeighbors(plane.getCellWithXandY(2, 10)) == 1);


    }

    @Test
    public void getCellWithXandY() throws Exception {
        Plane plane = new Plane();
        assertTrue(plane.getCellWithXandY(10, 10).equals(new Cell(10, 10)));
        assertTrue(plane.getCellWithXandY(11, 10).equals(new Cell(11, 10)));
        assertTrue(plane.getCellWithXandY(13, 10).equals(new Cell(13, 10)));
        assertTrue(plane.getCellWithXandY(19, 18).equals(new Cell(19, 18)));


    }


}
