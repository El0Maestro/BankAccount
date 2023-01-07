package guiMVC.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectToData {

    public static void sendInformationToExcel(String path){
        // Wyœlij informacje z pliku podanego w parametrze "path" do arkusza Excel
    }

    //Wyœlij dane do interfejsu graficznego z bazy danych
    public static String[][] getDataToGUI() {
        Excel.main(); // wywo³anie metody main() z klasy Excel
        String[][] data = Excel.getData(); // pobranie danych z klasy Excel

        // Przekszta³cenie danych z tablicy String na format odpowiedni do wyœwietlenia w tabeli
        String[][] dataForTable = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            String[] row = data[i];
            dataForTable[i] = new String[row.length];
            for (int j = 0; j < row.length; j++) {
                dataForTable[i][j] = row[j];
            }
        }

        return dataForTable;
    }

    public static void ReceivingDataFromExcel(String[][] ListFromExcel) {
        SendDataToDataBase(ListFromExcel);
    }

    private static void SendDataToDataBase(String[][] listTransactions) {
        List<String> transactions = Arrays.stream(listTransactions).map(Arrays::toString).collect(Collectors.toList());
        //Send(transactions)
    }
}
