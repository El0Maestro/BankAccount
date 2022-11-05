import javax.swing.*;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends JFrame implements ActionListener {

    JButton chooseFileButton, closeWindowButton;
    JLabel dateShowLabel, backgroundLabel, fileDirectoryLabel;
    JFrame frame;
    ImageIcon bcg;
    JFileChooser fileChooser;
    static File file;


    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    final Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font clickFont = new Font("SansSerif", Font.PLAIN, 13);
    final Font fileFont = new Font("SansSerif", Font.BOLD, 20);
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public GUI() {
        bcg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("bankbcg.png")));

        fileChooser = new JFileChooser();

        backgroundLabel = new JLabel(bcg);
        backgroundLabel.setSize(1052, 720);

        chooseFileButton = new JButton("FILE");
        chooseFileButton.setVisible(true);
        chooseFileButton.setBounds(475, 287, 100, 37);
        chooseFileButton.addActionListener(this);
        chooseFileButton.setBorderPainted(false);
        chooseFileButton.setContentAreaFilled(false);
        chooseFileButton.setFocusPainted(false);
        chooseFileButton.setOpaque(false);

        closeWindowButton = new JButton("EXIT");
        closeWindowButton.setVisible(true);
        closeWindowButton.setBounds(888, 663, 100, 37);
        closeWindowButton.addActionListener(this);
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

        fileDirectoryLabel = new JLabel();
        fileDirectoryLabel.setFont(fileFont);
        fileDirectoryLabel.setVisible(true);
        fileDirectoryLabel.setBounds(300,205,500,60);

        frame = new JFrame("Bank Account Binder");
        frame.setSize(1052, 755);
        frame.setLayout(null);
        frame.add(backgroundLabel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        backgroundLabel.add(chooseFileButton);
        backgroundLabel.add(closeWindowButton);
        backgroundLabel.add(dateShowLabel);
        backgroundLabel.add(fileDirectoryLabel);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dateShowLabel.setText(dateFormat.format(new Date()));
        Object source = e.getSource();
        if (source == chooseFileButton) {
            chooseFileButton.setFont(clickFont);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                fileDirectoryLabel.setText(file.toString());
                Excel.main(Excel.file.list());
            }
        } else if (source == closeWindowButton) {
            closeWindowButton.setFont(clickFont);
            frame.dispose();
            System.exit(0);
        } else {
            chooseFileButton.setFont(defFont);
            closeWindowButton.setFont(defFont);
        }
    }
}
