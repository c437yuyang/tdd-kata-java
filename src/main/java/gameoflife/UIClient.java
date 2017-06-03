package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Created by Peng on 2017/6/3.
 */
public class UIClient extends JFrame {

    private Plane plane;
    private List<JButton> btnGrids = new ArrayList<>();
    private JButton btnNext = new JButton();
    private Generation generation;

    public UIClient(Plane plane) {
        super();
        this.plane = plane;
        plane.setAliveCells(); //for debug
        generation = new Generation(plane); //for debug
        int width = 600;
        int height = 600;
        setSize(width, height);
        int rows = Plane.getWIDTH();
        int cols = Plane.getHEIGHT();
        setLocationRelativeTo(null);

        Panel panelGrids = new Panel();
        Panel panelControl = new Panel();
        setLayout(new BorderLayout());
        add(panelGrids);
        add(panelControl, BorderLayout.AFTER_LAST_LINE);

        btnNext.setText("Next Generation");
        panelControl.add(btnNext);
        panelGrids.setLayout(new GridLayout(rows, cols));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        for (int i = 0; i < rows * cols; i++) { //init buttons
            JButton button = new JButton();
            btnGrids.add(button);
            panelGrids.add(button);
            addButtonClickEvent(button);
        }
        updateGridsColorByCells();
        addNextClickEvent();
        setVisible(true);
    }


    private void addButtonClickEvent(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = btnGrids.indexOf(button);
                Cell relCell = plane.getCellWithIndex(index);
                CellState currentState = relCell.getCellState();
                relCell.setCellState(reverseState(currentState));
                setGridColorByRelativeCell(relCell);
            }
        });
    }


    private void addNextClickEvent() {
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generation.updateCellsState();
                updateGridsColorByCells();
            }
        });
    }

    private void updateGridsColorByCells() {
        for (int i = 0; i < btnGrids.size(); i++) {
            Cell relCell = plane.getCellWithIndex(i);
            setGridColorByRelativeCell(relCell);
        }
    }

    private void setGridColorByRelativeCell(Cell cell) {
        if (cell.getCellState() == CellState.DEAD) {
            btnGrids.get(cell.getY() * Plane.getWIDTH() + cell.getX()).setBackground(Color.black);

        } else {
            btnGrids.get(cell.getY() * Plane.getWIDTH() + cell.getX()).setBackground(Color.white);
        }
    }

    public CellState reverseState(CellState cellState) {
        if (cellState == CellState.ALIVE) {
            return CellState.DEAD;
        } else {
            return CellState.ALIVE;
        }
    }


}
