package gameoflife;

/**
 * Created by Peng on 2017/6/3.
 */
public class Rule {

    public CellState nextState(CellState currentState, int aliveNeighbors) {
        CellState result = CellState.DEAD;
        if ((currentState == CellState.ALIVE && aliveNeighbors >= 2 && aliveNeighbors <= 3)) {
            result = CellState.ALIVE;
        }

        if (currentState == CellState.DEAD && aliveNeighbors == 3) {
            result = CellState.ALIVE;
        }

        return result;
    }


}
