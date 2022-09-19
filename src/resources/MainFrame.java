package resources;

import java.awt.*;
import javax.swing.*;

import resources.operations.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setFocusable(true);
        setFocusableWindowState(true);
        setResizable(false);

        add(new TicTacToe());

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
    }
}
