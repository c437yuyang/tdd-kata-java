package gameoflife;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 * Created by Peng on 2017/6/3.
 */
public class UIClient extends JFrame {

    private Plane plane;

    public UIClient(Plane plane) {

        super();

        this.plane = plane;
        int width = 600;
        int height = 600;
        int rows = Plane.getWIDTH();
        int cols = Plane.getHEIGHT();
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(rows, cols));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JButton[] button = new JButton[rows * cols];

        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton();
            if (plane.getCellWithIndex(i).getCellState() == CellState.ALIVE) {
                button[i].setBackground(Color.white);
            } else {
                button[i].setBackground(Color.black);
            }
            add(button[i]);
        }
        setVisible(true);
    }


}
