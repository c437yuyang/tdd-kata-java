package gameoflife;

import org.junit.Test;


/**
 * Created by Peng on 2017/6/3.
 */
public class GenerationTest {

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
