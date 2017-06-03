package gameoflife;

/**
 * Created by Peng on 2017/6/3.
 */
public class Rule {

    public static CellState nextState(CellState currentState, int aliveNeighbors) {
        CellState result = currentState;
        if ((currentState == CellState.ALIVE && (aliveNeighbors <= 1 || aliveNeighbors > 3))) {
            result = CellState.DEAD;
        }

        if (currentState == CellState.DEAD && aliveNeighbors == 3) {
            result = CellState.ALIVE;
        }

        return result;
    }


}
