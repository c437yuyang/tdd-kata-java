package gameoflife;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * Created by Peng on 2017/6/3.
 */
public class GenerationTest {

    @Test
    public void checkCellEqual() throws Exception {
        Cell cell1 = new Cell(1, 1);
        Cell cell2 = new Cell(1, 1);
        assertTrue(Generation.checkCellEqual(cell1, cell2));
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

}
