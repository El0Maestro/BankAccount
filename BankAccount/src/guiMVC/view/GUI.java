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

    // Przyciski interfejsu u�ytkownika
    JButton chooseFileScreenButton, showListScreenButton, closeWindowButton, backToMainButton, backToMainButton1, chooseFileButton;
    // Etykiety do wy�wietlania tekstu
    JLabel dateShowLabel, fileDirectoryLabel, dateShowLabel1, dateShowLabel2, mainBcg, fileChooseBcg, showDataBcg;
    // Ikony obrazk�w do wy�wietlenia na tle okna aplikacji
    ImageIcon bcg, bcg1, bcg2;
    // G��wne okno aplikacji oraz okna dla wyboru pliku i wy�wietlania danych
    public static JFrame mainFrame, fileChooseFrame, dataShowFrame;
    // Narz�dzie do wyboru pliku z dysku
    JFileChooser fileChooser;

    // Zmienna do przechowywania wczytanego pliku
    public static File choosedFile;

    // Czcionki do u�ycia w aplikacji
    final Font dateFont = new Font("SansSerif", Font.ITALIC, 33);
    public static Font defFont = new Font("SansSerif", Font.BOLD, 18);
    final Font fileFont = new Font("SansSerif", Font.BOLD, 30);
    // Format daty i godziny
    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public GUI() {
        // Ustawienie rozmiaru i layoutu okna aplikacji
        setSize(1052, 759);
        setLayout(null);
        // Ustawienie domy�lnej akcji po zamkni�ciu okna (zako�czenie dzia�ania programu)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Utworzenie obiektu zawieraj�cego teksty do wy�wietlenia
        Text text = new Text();

        // Wczytanie obrazk�w do wy�wietlenia na tle okna aplikacji
        bcg2 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/showDataFromFile.png")));
        bcg1 = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fileselectbng.png")));
        bcg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/mainbcg.png")));
        // Utworzenie narz�dzia do wyboru pliku z dysku
        fileChooser = new JFileChooser();

        // Tworzenie przycisku do zamykania okna aplikacji
        closeWindowButton = new JButton(text.getClose());
        closeWindowButton.setVisible(true);
        closeWindowButton.setBounds(873, 665, 130, 37);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        closeWindowButton.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        closeWindowButton.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        closeWindowButton.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        closeWindowButton.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        closeWindowButton.setOpaque(false);

        // Tworzenie przycisku do powrotu do g��wnego okna aplikacji
        backToMainButton = new JButton(text.getBack());
        backToMainButton.setVisible(true);
        backToMainButton.setBounds(873, 665, 130, 37);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        backToMainButton.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        backToMainButton.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        backToMainButton.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        backToMainButton.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        backToMainButton.setOpaque(false);

        // Tworzenie drugiego przycisku do powrotu do g��wnego okna aplikacji
        backToMainButton1 = new JButton(text.getBack());
        backToMainButton1.setVisible(true);
        backToMainButton1.setBounds(873, 665, 130, 37);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        backToMainButton1.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        backToMainButton1.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        backToMainButton1.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        backToMainButton1.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        backToMainButton1.setOpaque(false);

        // Tworzenie przycisku do wybrania pliku z dysku
        chooseFileButton = new JButton(text.getChoose());
        chooseFileButton.setVisible(true);
        chooseFileButton.setBounds(475, 287, 100, 37);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        chooseFileButton.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        chooseFileButton.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        chooseFileButton.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        chooseFileButton.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        chooseFileButton.setOpaque(false);
        // Ustawienie czcionki dla przycisku
        setFont(fileFont);

        // Tworzenie przycisku do przej�cia do okna wyboru pliku z danymi
        chooseFileScreenButton = new JButton(text.getReadData());
        chooseFileScreenButton.setVisible(true);
        chooseFileScreenButton.setBounds(23, 200, 250, 50);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        chooseFileScreenButton.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        chooseFileScreenButton.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        chooseFileScreenButton.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        chooseFileScreenButton.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        chooseFileScreenButton.setOpaque(false);

        // Tworzenie przycisku do wy�wietlenia wczytanych danych
        showListScreenButton = new JButton(text.getShowData());
        showListScreenButton.setVisible(true);
        showListScreenButton.setBounds(24, 266, 250, 50);
        // Dodanie obs�ugi zdarze� dla przycisku (reakcja na klikni�cie)
        showListScreenButton.addActionListener(this);
        // Wy��czenie rysowania ramki wok� przycisku
        showListScreenButton.setBorderPainted(false);
        // Wy��czenie wype�nienia kolorem przycisku
        showListScreenButton.setContentAreaFilled(false);
        // Wy��czenie efektu "pod�wietlenia" przycisku po najechaniu na niego myszk�
        showListScreenButton.setFocusPainted(false);
        // Wy��czenie rysowania t�a przycisku
        showListScreenButton.setOpaque(false);

        // Tworzenie etykiety wy�wietlaj�cej aktualny czas i dat�
        dateShowLabel = new JLabel();
        dateShowLabel.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel.setFont(dateFont);

        // Tworzenie etykiety wy�wietlaj�cej �cie�k� do wybranego pliku
        fileDirectoryLabel = new JLabel();
        fileDirectoryLabel.setBounds(300, 205, 500, 60);
        // Ustawienie czcionki dla etykiety
        fileDirectoryLabel.setFont(defFont);

        // Tworzenie etykiety wy�wietlaj�cej aktualny czas i dat� (w oknie wyboru pliku)
        dateShowLabel1 = new JLabel();
        dateShowLabel1.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel1.setFont(dateFont);

        // Tworzenie etykiety wy�wietlaj�cej aktualny czas i dat� (w oknie wy�wietlania danych)
        dateShowLabel2 = new JLabel();
        dateShowLabel2.setBounds(76, 646, 500, 70);
        // Ustawienie czcionki dla etykiety
        dateShowLabel2.setFont(dateFont);

        // Tworzenie t�a dla g��wnego okna aplikacji
        mainBcg = new JLabel();
        mainBcg.setIcon(bcg);
        mainBcg.setBounds(0, 0, 1052, 759);

        // Tworzenie t�a dla okna wyboru pliku
        fileChooseBcg = new JLabel();
        fileChooseBcg.setIcon(bcg1);
        fileChooseBcg.setBounds(0, 0, 1052, 759);

        // Tworzenie t�a dla okna wyboru pliku
        showDataBcg = new JLabel();
        showDataBcg.setIcon(bcg2);
        showDataBcg.setBounds(0, 0, 1052, 759);

        // Utworzenie g��wnego okna aplikacji
        mainFrame = new JFrame(text.getBankAcc());
        // Ustawienie t�a dla okna
        mainFrame.setContentPane(mainBcg);
        // Ustawienie rozmiaru okna
        mainFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na �rodku ekranu
        mainFrame.setLocationRelativeTo(null);
        // Zablokowanie mo�liwo�ci zmiany rozmiaru okna
        mainFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma by� wykonana po zamkni�ciu okna
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Utworzenie okna wyboru pliku z danymi
        fileChooseFrame = new JFrame(text.getFileScreen());
        // Ustawienie t�a dla okna
        fileChooseFrame.setContentPane(fileChooseBcg);
        // Ustawienie rozmiaru okna
        fileChooseFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na �rodku ekranu
        fileChooseFrame.setLocationRelativeTo(null);
        // Zablokowanie mo�liwo�ci zmiany rozmiaru okna
        fileChooseFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma by� wykonana po zamkni�ciu okna
        fileChooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Utworzenie okna wy�wietlaj�cego wczytane dane
        dataShowFrame = new JFrame(text.getFilePresentation());
        // Ustawienie t�a dla okna
        dataShowFrame.setContentPane(showDataBcg);
        // Ustawienie rozmiaru okna
        dataShowFrame.setSize(1052, 759);
        // Ustawienie pozycji okna na �rodku ekranu
        dataShowFrame.setLocationRelativeTo(null);
        // Zablokowanie mo�liwo�ci zmiany rozmiaru okna
        dataShowFrame.setResizable(false);
        // Zdefiniowanie akcji, jaka ma by� wykonana po zamkni�ciu okna
        dataShowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dodanie przycisk�w i etykiet do g��wnego okna aplikacji
        mainFrame.add(closeWindowButton);
        mainFrame.add(chooseFileScreenButton);
        mainFrame.add(showListScreenButton);
        mainFrame.add(dateShowLabel);

        // Dodanie przycisk�w i etykiet do okna wy�wietlania danych
        dataShowFrame.add(backToMainButton1);
        dataShowFrame.add(dateShowLabel2);

        // Dodanie przycisk�w i etykiet do okna wyboru plik�w
        fileChooseFrame.add(backToMainButton);
        fileChooseFrame.add(chooseFileButton);
        fileChooseFrame.add(fileDirectoryLabel);
        fileChooseFrame.add(dateShowLabel1);

        // Ustawienie aktualnego czasu i daty w etykietach
        dateShowLabel.setText(dateFormat.format(new Date()));
        dateShowLabel1.setText(dateFormat.format(new Date()));
        dateShowLabel2.setText(dateFormat.format(new Date()));

        // Okre�lenie co ma si� dzia� co 1000 milisekund (1 sekunda)
        // Aktualizacja daty
        Timer timer = new Timer(1000, e -> {
            dateShowLabel.setText(dateFormat.format(new Date()));
            dateShowLabel1.setText(dateFormat.format(new Date()));
            dateShowLabel2.setText(dateFormat.format(new Date()));
        });
        // Uruchomienie timera
        timer.start();
        // Ustawienie g��wnego okna aplikacji jako widocznego
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Je�li przycisk "Zamknij" zostanie naci�ni�ty, zamknij aplikacj�
        if (e.getSource() == closeWindowButton) {
            System.exit(0);
        }

        // Je�li przycisk "Czytaj dane" zostanie naci�ni�ty, otw�rz okno wyboru pliku z danymi
        if (e.getSource() == chooseFileScreenButton) {
            // Otwarcie okna z wyborem pliku danych
            fileChooseFrame.setVisible(true);
            // Ukrycie okna g��wnego
            mainFrame.setVisible(false);
            dataShowFrame.setVisible(false);
        }

        // Je�li przycisk "Wy�wietl dane" zostanie naci�ni�ty, otw�rz okno wy�wietlenia danych
        if (e.getSource() == showListScreenButton) {
            // Ukrycie okna g��wnego
            mainFrame.setVisible(false);
            // Otwarcie okna z danymi
            dataShowFrame.setVisible(true);
            ConnectToData.getDataToGUI(choosedFile);
        }

        // Je�li przycisk "Powr�t" zostanie naci�ni�ty, wr�� do g��wnego okna aplikacji
        if (e.getSource() == backToMainButton) {
            fileChooseFrame.setVisible(false);
            mainFrame.setVisible(true);
            dataShowFrame.setVisible(false);
        }
        // Je�li przycisk "Powr�t(2)" zostanie naci�ni�ty, wr�� do g��wnego okna aplikacji
        if (e.getSource() == backToMainButton1) {
            fileChooseFrame.setVisible(false);
            mainFrame.setVisible(true);
            dataShowFrame.setVisible(false);
        }

        if (e.getSource() == chooseFileButton) {
            // Otwarcie okna wyboru pliku
            int returnVal = fileChooser.showOpenDialog(fileChooseFrame);
            // Je�li zostanie wybrany plik, zapisz jego �cie�k� do zmiennej "file" i wy�wietl j� w etykiecie
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                choosedFile = fileChooser.getSelectedFile();
                fileDirectoryLabel.setText(choosedFile.getAbsolutePath());
                // Uruchom klas� Excel z wybranym plikiem
                Excel.getDataFromExcel(choosedFile);
            }
        }
    }
}



