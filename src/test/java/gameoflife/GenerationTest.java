package gameoflife;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;


/**
 * Created by Peng on 2017/6/3.
 */
public class GenerationTest {

    @Test
    public void checkCellEqual() throws Exception {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 1);
        Cell cell3 = new Cell(2, 1);
        Cell cell4 = new Cell(1, 2);

        assertTrue(Generation.checkCellEqual(cell1, cell2));
        assertTrue(!Generation.checkCellEqual(cell3, cell2));
        assertTrue(!Generation.checkCellEqual(cell4, cell2));

    }

    @Test
    public void getNextGenerationTest() {
        Plane plane = new Plane();
        plane.setAliveCells();
        Generation generation = new Generation(plane);
        plane.printCellsStates();
        System.out.println();
        System.out.println();
        generation.updateCellsState();
        plane.printCellsStates();
        System.out.println();
        System.out.println();
        generation.updateCellsState();
        plane.printCellsStates();
    }

    @Test
    public void shouldReturnFalseWhenSizeDoseNotMatch() {
        List<Cell> cells1 = new ArrayList<>(10);
        List<Cell> cells2 = new ArrayList<>(11);

        for (int i = 0; i != 10; ++i) {
            Cell cell = new Cell(1, 2);
            cells1.add(cell);
            cells2.add(cell);
        }
        cells2.add(new Cell(1, 3));
        assertTrue(!Generation.checkStopUpdate(cells1, cells2));
    }

    @Test
    public void shouldReturnFalseWhenStopUpdate() {
        Plane plane = new Plane();

        Generation generation = new Generation(plane);
        generation.updateCellsState();
        generation.updateCellsState();
        assertTrue(!generation.updateCellsState());     //两此应该停止

    }

}
