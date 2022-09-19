package resources.operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe extends JPanel implements ActionListener {
    Random random = new Random();
    JPanel buttonPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel("", JLabel.CENTER);
    JButton[] buttons = new JButton[9];

    boolean player1_turn;

    private final int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;

    public TicTacToe() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setLayout(new BorderLayout());

        Font font = new Font("Times new roman", Font.BOLD, 30);

        title.setFont(font);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.GREEN);

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);

        add(titlePanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(font);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        add(buttonPanel, BorderLayout.CENTER);
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setBackground(Color.GREEN);
                        buttons[i].setText("X");
                        player1_turn = false;
                        title.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setBackground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn = true;
                        title.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    protected void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            title.setText("X's turn");
        } else {
            player1_turn = false;
            title.setText("O's turn");
        }
    }

    protected void check() {

    }

}
