package guiMVC.controller;

import guiMVC.view.GUI;


import javax.swing.*;

import DB.db;

import java.awt.Dimension;
import java.io.File;
import java.util.Arrays;
import java.util.List;


public class ConnectToData {

    //Wy?lij dane do interfejsu graficznego z bazy danych
    public static String[][] getDataToGUI(File choosedFile)  {
        // Tutaj implementacja metody getData, np.:
        List<String[]> dataList = Excel.getDataFromExcel(choosedFile);
        String[][] data = dataList.toArray(new String[0][]);
        // Tworzenie panelu do wyświetlania danych z możliwością przewijania
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        GUI.dataShowFrame.add(scrollPane);
        // Tworzenie panelu do wyświetlania danych
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        // Iterowanie po wierszach danych
        for (int i = 0; i < data.length; i++) {
            // Iterowanie po kolumnach danych
            for (int j = 0; j < data[i].length; j++) {
                // Tworzenie etykiety do wyświetlania aktualnie przetwarzanej komórki
                JLabel cellLabel = new JLabel(data[i][j]);
                // Ustawienie pozycji etykiety na ekranie
                cellLabel.setBounds(25 + j * 200, 20 + i * 30, 150, 30);
                // Ustawienie podstawowej czcionki
                cellLabel.setFont(GUI.defFont);
                // Dodanie etykiety do panelu do wyświetlania danych
                dataPanel.add(cellLabel);
            }
        }
        // Ustawienie wielkości panelu do wyświetlania danych
        int width = 25 + data[0].length * 200;
        int height = 100 + data.length * 30;
        scrollPane.setBounds(20, 102, 1000, 450);
        dataPanel.setPreferredSize(new Dimension(width, height));
        // Dodanie panelu do wyświetlania danych do panelu z możliwością przewijania
        scrollPane.setViewportView(dataPanel);
        return data;
    }


    public static void ReceivingDataFromExcel(String[][] ListFromExcel) {
        SendDataToDataBase(ListFromExcel);
    }


    private static void SendDataToDataBase(String[][] listTransactions) {
        //List<String> transactions = Arrays.stream(listTransactions).map(Arrays::toString).toList();
        db baza = new db();
        baza.connect();
        baza.init();
        baza.insert(listTransactions);
        baza.disconnect();
    }

    public static String ReceiveDataFromDatabase(/*String stmt */) {
        //List<String> transactions = Arrays.stream(listTransactions).map(Arrays::toString).toList();
        db baza = new db();
        baza.connect();
        baza.init();
        String result = baza.select("1=1");
        baza.disconnect();
        return result;
    }
}
