import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    JButton chooseFile, closeWindow;
    JLabel dateShow, background, fileDirectory;
    JFrame frame;
    ImageIcon bcg;
    JFileChooser fileChooser;


    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    final Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font clickFont = new Font("SansSerif", Font.PLAIN, 13);

    final Font fileFont = new Font("SansSerif", Font.BOLD, 20);
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    public GUI() {
        bcg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("bankbcg.png")));

        fileChooser = new JFileChooser();


        background = new JLabel(bcg);
        background.setSize(1052, 720);

        chooseFile = new JButton("FILE");
        chooseFile.setVisible(true);
        chooseFile.setBounds(475, 287, 100, 37);
        chooseFile.addActionListener(this);
        chooseFile.setBorderPainted(false);
        chooseFile.setContentAreaFilled(false);
        chooseFile.setFocusPainted(false);
        chooseFile.setOpaque(false);

        closeWindow = new JButton("EXIT");
        closeWindow.setVisible(true);
        closeWindow.setBounds(888, 663, 100, 37);
        closeWindow.addActionListener(this);
        closeWindow.setBorderPainted(false);
        closeWindow.setContentAreaFilled(false);
        closeWindow.setFocusPainted(false);
        closeWindow.setOpaque(false);

        dateShow = new JLabel();
        dateShow.setVisible(true);
        dateShow.setFont(dateFont);
        dateShow.setBounds(76, 646, 500, 70);
        add(dateShow);
        new Timer(500, this).start();

        fileDirectory = new JLabel();
        fileDirectory.setFont(fileFont);
        fileDirectory.setVisible(true);
        fileDirectory.setBounds(300,205,500,60);

        frame = new JFrame("Bank Account Binder");
        frame.setSize(1052, 755);
        frame.setLayout(null);
        frame.add(background);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        background.add(chooseFile);
        background.add(closeWindow);
        background.add(dateShow);
        background.add(fileDirectory);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dateShow.setText(dateFormat.format(new Date()));
        Object source = e.getSource();
        if (source == chooseFile) {
            chooseFile.setFont(clickFont);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                fileDirectory.setText(file.toString());
            }
        } else if (source == closeWindow) {
            closeWindow.setFont(clickFont);
            frame.dispose();
            System.exit(0);
        } else {
            chooseFile.setFont(defFont);
            closeWindow.setFont(defFont);
        }
    }
}
