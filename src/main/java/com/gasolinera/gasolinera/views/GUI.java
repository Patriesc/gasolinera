package com.gasolinera.gasolinera.views;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private static JFrame frame1;
    private static JPanel panel = new JPanel();
    private static JScrollPane scrollPane;
    private static ArrayList<JButton> buttons;
    private static int numPumps;

    GUI(int numPumps) {
        this.numPumps = numPumps;
        frame1 = new JFrame("Gasolinera");
        scrollPane = new JScrollPane(panel);
        frame1.setBounds(400, 150, 300, 500);
        frame1.add(scrollPane, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(numPumps, 1));

        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame1.setVisible(true);

        buttons = new ArrayList<>();
        for (int i = 0; i < numPumps; i++)
            buttons.add(new JButton());

        for (int i = 0; i < numPumps; i++) {
            panel.add(buttons.get(i));
        }

    }

    public static void setColorRed(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i + 1) + ": " + msg);
        buttons.get(i).setBackground(Color.RED);
    }

    public static void setColorYellow(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i + 1) + ": " + msg);
        buttons.get(i).setBackground(Color.YELLOW);
    }

    public static void setColorGreen(int i, String msg) {
        buttons.get(i).setText("Surtidor " + (i + 1) + ": " + msg);
        buttons.get(i).setBackground(Color.GREEN);
    }

}

