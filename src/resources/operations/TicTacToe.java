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

        Font font = new Font("Arial", Font.BOLD, 32);

        title.setFont(font);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.GREEN);

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);

        add(titlePanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3, 3, 2, 2));

        font = new Font("Arial Rounded MT", Font.BOLD, 128);

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
                        buttons[i].setBackground(Color.ORANGE);
                        buttons[i].setText("X");
                        player1_turn = false;
                        title.setText("O's turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.WHITE);
                        buttons[i].setBackground(Color.BLUE);
                        buttons[i].setText("O");
                        player1_turn = true;
                        title.setText("X's turn");
                        check();
                    }
                }
            }
        }

    }

    protected void firstTurn() {
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            title.setText("X's turn");
        } else {
            player1_turn = false;
            title.setText("O's turn");
        }
    }

    protected void check() {
        // Checking for X

        // Horizontal for X
        if (buttons[0].getText() == "X" &&
                buttons[1].getText() == "X" &&
                buttons[2].getText() == "X")
            winner_X(0, 1, 2);

        else if (buttons[3].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[5].getText() == "X")
            winner_X(3, 4, 5);

        else if (buttons[6].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[8].getText() == "X")
            winner_X(6, 7, 8);

        // Vertical for X
        else if (buttons[0].getText() == "X" &&
                buttons[3].getText() == "X" &&
                buttons[6].getText() == "X")
            winner_X(0, 3, 6);

        else if (buttons[1].getText() == "X" && buttons[4].getText() == "X"
                && buttons[7].getText() == "X")
            winner_X(1, 4, 7);

        else if (buttons[2].getText() == "X" && buttons[5].getText() == "X"
                && buttons[8].getText() == "X")
            winner_X(2, 5, 8);

        // Diagonal for X
        else if (buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "X")
            winner_X(0, 4, 8);

        else if (buttons[2].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[6].getText() == "X")
            winner_X(2, 4, 6);

        // Checking for O

        // Horizontal for O
        if (buttons[0].getText() == "O" &&
                buttons[1].getText() == "O" &&
                buttons[2].getText() == "O")
            winner_O(0, 1, 2);

        else if (buttons[3].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[5].getText() == "O")
            winner_O(3, 4, 5);

        else if (buttons[6].getText() == "O" &&
                buttons[7].getText() == "O" &&
                buttons[8].getText() == "O")
            winner_O(6, 7, 8);

        // Vertical for O
        else if (buttons[0].getText() == "O" &&
                buttons[3].getText() == "O" &&
                buttons[6].getText() == "O")
            winner_O(0, 3, 6);

        else if (buttons[1].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[7].getText() == "O")
            winner_O(1, 4, 7);

        else if (buttons[2].getText() == "O"
                && buttons[5].getText() == "O"
                && buttons[8].getText() == "O")
            winner_O(2, 5, 8);

        // Diagonal for O
        else if (buttons[0].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[8].getText() == "O")
            winner_O(0, 4, 8);

        else if (buttons[2].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[6].getText() == "O")
            winner_O(2, 4, 6);
    }

    protected void winner_X(int a, int b, int c) {
        for (int i = 0; i < 9; i++)
            if (i != a && i != b && i != c) {
                buttons[i].setEnabled(false);
            }

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        title.setText("X wins");
    }

    protected void winner_O(int a, int b, int c) {
        for (int i = 0; i < 9; i++)
            if (i != a && i != b && i != c) {
                buttons[i].setEnabled(false);
            }

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        title.setText("O wins");
    }
}
