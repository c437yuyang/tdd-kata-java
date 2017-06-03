package gameoflife;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

/**
 * Created by Peng on 2017/6/3.
 */
public class RuleTest {

    @Test
    public void shouldAliveChangeToDead() {
//        Rule.nextState(CellState.ALIVE,5);
        assertTrue(Rule.nextState(CellState.ALIVE, 5) == CellState.DEAD);
    }


    @Test
    public void shouldDeadChangeToAlive() {
        assertTrue(Rule.nextState(CellState.DEAD, 3) == CellState.ALIVE);
    }

    @Test
    public void shouldKeepState() {
        assertTrue(Rule.nextState(CellState.DEAD, 2) == CellState.DEAD);
        assertTrue(Rule.nextState(CellState.DEAD, 1) == CellState.DEAD);
        assertTrue(Rule.nextState(CellState.ALIVE, 2) == CellState.ALIVE);
        assertTrue(Rule.nextState(CellState.DEAD, 5) == CellState.DEAD);
    }


}
