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
import javax.swing.JOptionPane;


/**
 * Created by Peng on 2017/6/3.
 */
public class UIClient extends JFrame {

    public static final int WND_WIDTH = 600;
    public static final int WND_HEIGHT = 600;
    private Plane plane;
    private List<JButton> btnGrids = new ArrayList<>();
    private JButton btnNext = new JButton();
    private JButton btnStart = new JButton();
    private JButton btnEnd = new JButton();
    private boolean isRunning = false;
    private Generation generation;
    private GenerationUpdateThread generationUpdateThread;

    public UIClient(Plane plane) {
        super();
        this.plane = plane;
        plane.setAliveCells(); //for debug
        generation = new Generation(plane); //for debug
        initWindow();
        updateGridsColorByCells();
        setVisible(true);
    }

    private void initWindow() {
        setSize(WND_WIDTH, WND_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        Panel panelGrids = new Panel();
        Panel panelControl = new Panel();
        add(panelGrids);
        add(panelControl, BorderLayout.AFTER_LAST_LINE);
        initControlPanel(panelControl);
        initGridPanel(panelGrids);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initGridPanel(Panel panelGrids) {
        int rows = Plane.getWIDTH();
        int cols = Plane.getHEIGHT();
        panelGrids.setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows * cols; i++) { //init buttons
            JButton button = new JButton();
            btnGrids.add(button);
            panelGrids.add(button);
            addGridBtnClickEvent(button);
        }
    }

    private void initControlPanel(Panel panelControl) {
        btnNext.setText("Next Generation");
        btnStart.setText("Start");
        btnEnd.setText("End");
        btnEnd.setEnabled(false);
        panelControl.add(btnNext);
        panelControl.add(btnStart);
        panelControl.add(btnEnd);
        addStartBtnClickEvent();
        addNextBtnClickEvent();
        addEndBtnClickEvent();
    }

    private void addGridBtnClickEvent(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = btnGrids.indexOf(button);
                Cell relCell = plane.getCellWithIndex(index);
                CellState currentState = relCell.getCellState();
                relCell.setCellState(reverseState(currentState));
                setGridColorByRelativeCell(relCell);
            }
        });
    }

    private void addStartBtnClickEvent() {
        btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (generationUpdateThread != null) {
                    isRunning = false;
                }
                generationUpdateThread = new GenerationUpdateThread();

                generationUpdateThread.start();
                changeUIStateToStart();
            }
        });
    }

    private void addNextBtnClickEvent() {
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!generation.updateCellsState()) {
                    JOptionPane.showMessageDialog(null, "Cells Has Stop Update!");
                }
                updateGridsColorByCells();
            }
        });
    }

    private void addEndBtnClickEvent() {
        btnEnd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (generationUpdateThread == null) {
                    return;
                }
                if (isRunning) {
                    changeUIStateToStop();
                }

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

    class GenerationUpdateThread extends Thread {
        @Override
        public void run() {
            while (isRunning) {
                if (!generation.updateCellsState()) {
                    JOptionPane.showMessageDialog(null, "Cells Has Stop Update!");
                    changeUIStateToStop();
                    break;
                }
                updateGridsColorByCells();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void changeUIStateToStart() {
        isRunning = true;
        btnStart.setEnabled(false);
        btnEnd.setEnabled(true);
    }

    private void changeUIStateToStop() {
        isRunning = false;
        btnStart.setEnabled(true);
        btnEnd.setEnabled(false);
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        new UIClient(plane);
    }
}
