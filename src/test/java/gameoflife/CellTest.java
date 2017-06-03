package gameoflife;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by Peng on 2017/6/3.
 */
public class CellTest {
    @Test
    public void getX() throws Exception {
        Cell cell = new Cell(10, 10);
        assertTrue(cell.getX() == 10);
    }

    @Test
    public void getY() throws Exception {
        Cell cell = new Cell(10, 10);
        assertTrue(cell.getY() == 10);
    }

    @Test
    public void getCellState() throws Exception {
        Cell cell = new Cell(10, 10, CellState.ALIVE);
        assertTrue(cell.getCellState() == CellState.ALIVE);
        assertTrue(cell.getCellState() == CellState.valueOf("ALIVE"));
        assertTrue(cell.getCellState() == CellState.values()[0]);


    }


}
