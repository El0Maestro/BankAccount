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
        // tutaj implementacja metody getData, np.:
        String[][] data = new String[][] {
                {"1", "Jan", "Kowalski", "2000-01-01", "1000"},
                {"2", "Anna", "Nowak", "2000-02-02", "2000"},
                {"3", "Pawe³", "Wiœniewski", "2000-03-03", "3000"},
                {"4", "Gawe³", "Wiœniewski", "1999-02-01", "5000"},
                {"5", "Jarek", "Kaniewski", "2002-05-12", "2400"}
        };
        return data;
        //Wyœlij dane do interfejsu graficznego z bazy danych

    }

    public static void ReceivingDataFromExcel(String[][] ListFromExcel) {
        SendDataToDataBase(ListFromExcel);
    }

    private static void SendDataToDataBase(String[][] listTransactions) {
        List<String> transactions = Arrays.stream(listTransactions).map(Arrays::toString).collect(Collectors.toList());
        //Send(transactions)
    }
}
