package guiMVC.view;

import guiMVC.controller.Excel;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    JButton chooseFileScreen, closeWindowButton, backToMainButton, chooseFileButton;
    JLabel dateShowLabel, fileDirectoryLabel, dateShowLabel1, mainBcg, fileChooseBcg;
    ImageIcon bcg, bcg1;
    JFrame mainFrame, fileChooseFrame;
    JFileChooser fileChooser;

    public static File getFile() {
        return file;
    }

    static File file;

    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    final Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font clickFont = new Font("SansSerif", Font.PLAIN, 13);
    final Font fileFont = new Font("SansSerif", Font.BOLD, 30);
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public GUI() {
        setSize(1052, 759);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bcg1 = new ImageIcon(this.getClass().getResource("/fileselectbng.png"));
        bcg = new ImageIcon(this.getClass().getResource("/mainbcg.png"));
        fileChooser = new JFileChooser();


        closeWindowButton = new JButton("ZAMKNIJ");
        closeWindowButton.setVisible(true);
        closeWindowButton.setBounds(873, 665, 130, 37);
        closeWindowButton.addActionListener(this);
        closeWindowButton.setBorderPainted(false);
        closeWindowButton.setContentAreaFilled(false);
        closeWindowButton.setFocusPainted(false);
        closeWindowButton.setOpaque(false);

        backToMainButton = new JButton("WRÓÆ");
        backToMainButton.setVisible(true);
        backToMainButton.setBounds(873, 665, 130, 37);
        backToMainButton.addActionListener(this);
        backToMainButton.setBorderPainted(false);
        backToMainButton.setContentAreaFilled(false);
        backToMainButton.setFocusPainted(false);
        backToMainButton.setOpaque(false);

        chooseFileButton = new JButton("WYBIERZ");
        chooseFileButton.setVisible(true);
        chooseFileButton.setBounds(475, 287, 100, 37);
        chooseFileButton.addActionListener(this);
        chooseFileButton.setBorderPainted(false);
        chooseFileButton.setContentAreaFilled(false);
        chooseFileButton.setFocusPainted(false);
        chooseFileButton.setOpaque(false);
        setFont(fileFont);

        chooseFileScreen = new JButton("1.ODCZYTAJ DANE");
        chooseFileScreen.setVisible(true);
        chooseFileScreen.setBounds(23, 200, 250, 50);
        chooseFileScreen.addActionListener(this);
        chooseFileScreen.setBorderPainted(false);
        chooseFileScreen.setContentAreaFilled(false);
        chooseFileScreen.setFocusPainted(false);
        chooseFileScreen.setOpaque(false);

        dateShowLabel = new JLabel();
        dateShowLabel.setVisible(true);
        dateShowLabel.setFont(dateFont);
        dateShowLabel.setBounds(76, 646, 500, 70);
        add(dateShowLabel);
        new Timer(500, this).start();

        dateShowLabel1 = new JLabel();
        dateShowLabel1.setVisible(true);
        dateShowLabel1.setFont(dateFont);
        dateShowLabel1.setBounds(76, 646, 500, 70);
        add(dateShowLabel1);
        new Timer(500, this).start();

        mainBcg = new JLabel(bcg);
        mainBcg.setSize(1052, 720);

        fileChooseBcg = new JLabel(bcg1);
        fileChooseBcg.setSize(1052, 720);

        fileDirectoryLabel = new JLabel();
        fileDirectoryLabel.setFont(fileFont);
        fileDirectoryLabel.setVisible(true);
        fileDirectoryLabel.setBounds(300, 205, 500, 60);

        mainFrame = new JFrame("Bank Account Binder");
        mainFrame.setSize(1052, 759);
        mainFrame.setLayout(null);
        mainFrame.add(mainBcg);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        mainBcg.add(closeWindowButton);
        mainBcg.add(dateShowLabel);
        mainBcg.add(chooseFileScreen);

        fileChooseFrame = new JFrame("File choose screen");
        fileChooseFrame.setSize(1052, 759);
        fileChooseFrame.setLayout(null);
        fileChooseFrame.add(fileChooseBcg);
        fileChooseFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fileChooseFrame.setLocationRelativeTo(null);
        fileChooseFrame.setVisible(false);

        fileChooseBcg.add(dateShowLabel1);
        fileChooseBcg.add(fileChooser);
        fileChooseBcg.add(backToMainButton);
        fileChooseBcg.add(chooseFileButton);
        fileChooseBcg.add(fileDirectoryLabel);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dateShowLabel.setText(dateFormat.format(new Date()));
        dateShowLabel1.setText(dateFormat.format(new Date()));
        Object source = e.getSource();
        if (source == closeWindowButton) {
            closeWindowButton.setFont(clickFont);
            mainFrame.dispose();
            System.exit(0);
        } else if (source == chooseFileScreen) {
            chooseFileScreen.setFont(clickFont);
            mainFrame.setVisible(false);
            fileChooseFrame.setVisible(true);
        } else if (source == chooseFileButton) {
            chooseFileButton.setFont(clickFont);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                fileDirectoryLabel.setText(file.toString());
                Excel.main(Excel.getFile().list());
            }
        }else if (source == backToMainButton){
            mainFrame.setVisible(true);
            fileChooseFrame.setVisible(false);
        } else {
            closeWindowButton.setFont(defFont);
            chooseFileScreen.setFont(defFont);

        }
    }
}
