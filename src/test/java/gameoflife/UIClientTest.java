package gameoflife;

import org.junit.Test;

//import static org.junit.Assert.*;

/**
 * Created by Peng on 2017/6/3.
 */
public class UIClientTest {


    @Test
    public void testUICleint() {
        Plane plane = new Plane();
//        plane.setAliveCells();
        new UIClient(plane);
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
