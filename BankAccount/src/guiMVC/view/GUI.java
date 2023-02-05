package guiMVC.view;

import guiMVC.controller.ConnectToData;
import guiMVC.model.Text;
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

    // Przyciski interfejsu u¿ytkownika
    JButton chooseFileScreenButton, showListScreenButton, closeWindowButton, backToMainButton, backToMainButton1, chooseFileButton;
    // Etykiety do wyœwietlania tekstu
    JLabel dateShowLabel, fileDirectoryLabel, dateShowLabel1, dateShowLabel2, mainBcg, fileChooseBcg, showDataBcg;
    // Ikony obrazków do wyœwietlenia na tle okna aplikacji
    ImageIcon bcg, bcg1, bcg2;
    // G³ówne okno aplikacji oraz okna dla wyboru pliku i wyœwietlania danych
    public static JFrame mainFrame, fileChooseFrame, dataShowFrame;
    // Narzêdzie do wyboru pliku z dysku
    JFileChooser fileChooser;

    // Zmienna do przechowywania wczytanego pliku
    public static File choosedFile;

    // Czcionki do u¿ycia w aplikacji
    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    public static Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font fileFont = new Font("SansSerif", Font.BOLD, 30);
    // Format daty i godziny
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public GUI() {
        // Ustawienie rozmiaru i layoutu okna aplikacji
        setSize(1052, 759);
        setLayout(null);
        // Ustawienie domyœlnej akcji po zamkniêciu okna (zakoñczenie dzia³ania programu)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Utworzenie obiektu zawieraj¹cego teksty do wyœwietlenia
        Text text = new Text();

        // Wczytanie obrazków do wyœwietlenia na tle okna aplikacji
        bcg2 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/showDataFromFile.png")));
        bcg1 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fileselectbng.png")));
        bcg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/mainbcg.png")));
        // Utworzenie narzêdzia do wyboru pliku z dysku
        fileChooser = new JFileChooser();

        // Tworzenie przycisku do zamykania okna aplikacji
        closeWindowButton = new JButton(text.getClose());
        closeWindowButton.setVisible(true);
        closeWindowButton.setBounds(873, 665, 130, 37);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        closeWindowButton.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        closeWindowButton.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        closeWindowButton.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        closeWindowButton.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        closeWindowButton.setOpaque(false);

        // Tworzenie przycisku do powrotu do g³ównego okna aplikacji
        backToMainButton = new JButton(text.getBack());
        backToMainButton.setVisible(true);
        backToMainButton.setBounds(873, 665, 130, 37);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        backToMainButton.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        backToMainButton.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        backToMainButton.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        backToMainButton.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        backToMainButton.setOpaque(false);

        // Tworzenie drugiego przycisku do powrotu do g³ównego okna aplikacji
        backToMainButton1 = new JButton(text.getBack());
        backToMainButton1.setVisible(true);
        backToMainButton1.setBounds(873, 665, 130, 37);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        backToMainButton1.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        backToMainButton1.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        backToMainButton1.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        backToMainButton1.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        backToMainButton1.setOpaque(false);

        // Tworzenie przycisku do wybrania pliku z dysku
        chooseFileButton = new JButton(text.getChoose());
        chooseFileButton.setVisible(true);
        chooseFileButton.setBounds(475, 287, 100, 37);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        chooseFileButton.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        chooseFileButton.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        chooseFileButton.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        chooseFileButton.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        chooseFileButton.setOpaque(false);
        // Ustawienie czcionki dla przycisku
        setFont(fileFont);

        // Tworzenie przycisku do przejœcia do okna wyboru pliku z danymi
        chooseFileScreenButton = new JButton(text.getReadData());
        chooseFileScreenButton.setVisible(true);
        chooseFileScreenButton.setBounds(23, 200, 250, 50);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        chooseFileScreenButton.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        chooseFileScreenButton.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        chooseFileScreenButton.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        chooseFileScreenButton.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        chooseFileScreenButton.setOpaque(false);

        // Tworzenie przycisku do wyœwietlenia wczytanych danych
        showListScreenButton = new JButton(text.getShowData());
        showListScreenButton.setVisible(true);
        showListScreenButton.setBounds(24, 266, 250, 50);
        // Dodanie obs³ugi zdarzeñ dla przycisku (reakcja na klikniêcie)
        showListScreenButton.addActionListener(this);
        // Wy³¹czenie rysowania ramki wokó³ przycisku
        showListScreenButton.setBorderPainted(false);
        // Wy³¹czenie wype³nienia kolorem przycisku
        showListScreenButton.setContentAreaFilled(false);
        // Wy³¹czenie efektu "podœwietlenia" przycisku po najechaniu na niego myszk¹
        showListScreenButton.setFocusPainted(false);
        // Wy³¹czenie rysowania t³a przycisku
        showListScreenButton.setOpaque(false);

        // Tworzenie etykiety wyœwietlaj¹cej aktualny czas i datê
        dateShowLabel = new JLabel();
        dateShowLabel.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel.setFont(dateFont);

        // Tworzenie etykiety wyœwietlaj¹cej œcie¿kê do wybranego pliku
        fileDirectoryLabel = new JLabel();
        fileDirectoryLabel.setBounds(300, 205, 500, 60);
        // Ustawienie czcionki dla etykiety
        fileDirectoryLabel.setFont(defFont);

        // Tworzenie etykiety wyœwietlaj¹cej aktualny czas i datê (w oknie wyboru pliku)
        dateShowLabel1 = new JLabel();
        dateShowLabel1.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel1.setFont(dateFont);

        // Tworzenie etykiety wyœwietlaj¹cej aktualny czas i datê (w oknie wyœwietlania danych)
        dateShowLabel2 = new JLabel();
        dateShowLabel2.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel2.setFont(dateFont);

        // Tworzenie t³a dla g³ównego okna aplikacji
        mainBcg = new JLabel();
        mainBcg.setIcon(bcg);
        mainBcg.setBounds(0, 0, 1052, 759);

        // Tworzenie t³a dla okna wyboru pliku
        fileChooseBcg = new JLabel();
        fileChooseBcg.setIcon(bcg1);
        fileChooseBcg.setBounds(0, 0, 1052, 759);

        // Tworzenie t³a dla okna wyboru pliku
        showDataBcg = new JLabel();
        showDataBcg.setIcon(bcg2);
        showDataBcg.setBounds(0, 0, 1052, 759);

        // Utworzenie g³ównego okna aplikacji
        mainFrame = new JFrame(text.getBankAcc());
        // Ustawienie t³a dla okna
        mainFrame.setContentPane(mainBcg);
        // Ustawienie rozmiaru okna
        mainFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na œrodku ekranu
        mainFrame.setLocationRelativeTo(null);
        // Zablokowanie mo¿liwoœci zmiany rozmiaru okna
        mainFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma byæ wykonana po zamkniêciu okna
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Utworzenie okna wyboru pliku z danymi
        fileChooseFrame = new JFrame(text.getFileScreen());
        // Ustawienie t³a dla okna
        fileChooseFrame.setContentPane(fileChooseBcg);
        // Ustawienie rozmiaru okna
        fileChooseFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na œrodku ekranu
        fileChooseFrame.setLocationRelativeTo(null);
        // Zablokowanie mo¿liwoœci zmiany rozmiaru okna
        fileChooseFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma byæ wykonana po zamkniêciu okna
        fileChooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Utworzenie okna wyœwietlaj¹cego wczytane dane
        dataShowFrame = new JFrame(text.getFilePresentation());
        // Ustawienie t³a dla okna
        dataShowFrame.setContentPane(showDataBcg);
        // Ustawienie rozmiaru okna
        dataShowFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na œrodku ekranu
        dataShowFrame.setLocationRelativeTo(null);
        // Zablokowanie mo¿liwoœci zmiany rozmiaru okna
        dataShowFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma byæ wykonana po zamkniêciu okna
        dataShowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dodanie przycisków i etykiet do g³ównego okna aplikacji
        mainFrame.add(closeWindowButton);
        mainFrame.add(chooseFileScreenButton);
        mainFrame.add(showListScreenButton);
        mainFrame.add(dateShowLabel);

        // Dodanie przycisków i etykiet do okna wyœwietlania danych
        dataShowFrame.add(backToMainButton1);
        dataShowFrame.add(dateShowLabel2);

        // Dodanie przycisków i etykiet do okna wyboru plików
        fileChooseFrame.add(backToMainButton);
        fileChooseFrame.add(chooseFileButton);
        fileChooseFrame.add(fileDirectoryLabel);
        fileChooseFrame.add(dateShowLabel1);

        // Ustawienie aktualnego czasu i daty w etykietach
        dateShowLabel.setText(dateFormat.format(new Date()));
        dateShowLabel1.setText(dateFormat.format(new Date()));
        dateShowLabel2.setText(dateFormat.format(new Date()));

        // Okreœlenie co ma siê dziaæ co 1000 milisekund (1 sekunda)
        // Aktualizacja daty
        Timer timer = new Timer(1000, e -> {
            dateShowLabel.setText(dateFormat.format(new Date()));
            dateShowLabel1.setText(dateFormat.format(new Date()));
            dateShowLabel2.setText(dateFormat.format(new Date()));
        });
        // Uruchomienie timera
        timer.start();
        // Ustawienie g³ównego okna aplikacji jako widocznego
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Jeœli przycisk "Zamknij" zostanie naciœniêty, zamknij aplikacjê
        if (e.getSource() == closeWindowButton) {
            System.exit(0);
        }

        // Jeœli przycisk "Czytaj dane" zostanie naciœniêty, otwórz okno wyboru pliku z danymi
        if (e.getSource() == chooseFileScreenButton) {
            // Otwarcie okna z wyborem pliku danych
            fileChooseFrame.setVisible(true);
            // Ukrycie okna g³ównego
            mainFrame.setVisible(false);
            dataShowFrame.setVisible(false);
        }

        // Jeœli przycisk "Wyœwietl dane" zostanie naciœniêty, otwórz okno wyœwietlenia danych
        if (e.getSource() == showListScreenButton) {
            // Ukrycie okna g³ównego
            mainFrame.setVisible(false);
            // Otwarcie okna z danymi
            dataShowFrame.setVisible(true);
            ConnectToData.getDataToGUI(choosedFile);
        }

        // Jeœli przycisk "Powrót" zostanie naciœniêty, wróæ do g³ównego okna aplikacji
        if (e.getSource() == backToMainButton) {
            fileChooseFrame.setVisible(false);
            mainFrame.setVisible(true);
            dataShowFrame.setVisible(false);
        }
        // Jeœli przycisk "Powrót(2)" zostanie naciœniêty, wróæ do g³ównego okna aplikacji
        if (e.getSource() == backToMainButton1) {
            fileChooseFrame.setVisible(false);
            mainFrame.setVisible(true);
            dataShowFrame.setVisible(false);
        }

        if (e.getSource() == chooseFileButton) {
            // Otwarcie okna wyboru pliku
            int returnVal = fileChooser.showOpenDialog(fileChooseFrame);
            // Jeœli zostanie wybrany plik, zapisz jego œcie¿kê do zmiennej "file" i wyœwietl j¹ w etykiecie
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                choosedFile = fileChooser.getSelectedFile();
                fileDirectoryLabel.setText(choosedFile.getAbsolutePath());
                // Uruchom klasê Excel z wybranym plikiem
                Excel.getDataFromExcel(choosedFile);
            }
        }
    }
}



