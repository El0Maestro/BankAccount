package guiMVC.view;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    JButton chooseFileButton, closeWindowButton;
    JLabel dateShowLabel, background;
    ImageIcon bcg,bcg1;
    JPanel mainPanel, fileSelectPanel, showDataPanel;

    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    final Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font clickFont = new Font("SansSerif", Font.PLAIN, 13);
    final Font fileFont = new Font("SansSerif", Font.BOLD, 20);
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public GUI() {
        setSize(1052, 759);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bcg1 = new ImageIcon(this.getClass().getResource("/fileselectbng.png"));
        bcg = new ImageIcon(this.getClass().getResource("/mainbcg.png"));

        closeWindowButton = new JButton("EXIT");
        closeWindowButton.setVisible(true);
        closeWindowButton.setBounds(888, 663, 100, 37);
        closeWindowButton.setBorderPainted(false);
        closeWindowButton.setContentAreaFilled(false);
        closeWindowButton.setFocusPainted(false);
        closeWindowButton.setOpaque(false);

        dateShowLabel = new JLabel();
        dateShowLabel.setVisible(true);
        dateShowLabel.setFont(dateFont);
        dateShowLabel.setBounds(76, 646, 500, 70);
        add(dateShowLabel);
        new Timer(500, this).start();

        background = new JLabel("", bcg, JLabel.CENTER);
        background.setBounds(0, 0, 1052, 720);
        add(background);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dateShowLabel.setText(dateFormat.format(new Date()));
    }
}
