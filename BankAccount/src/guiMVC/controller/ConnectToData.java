package guiMVC.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConnectToData {

    public static void SendInfromationToExcel(String Path){
        /*String Path = "Plik_bankowy.xlsx";*/
        //informacja(path);
    }

    public static void SendDataToGUI(/*tablica[] tab || list*/){
        //Wysylam do GUI z DB
    }


    public static void ReceivingDataFromExcel(String[][] ListFromExcel){
        List<String> ListTransactions = new ArrayList<>();
        for (String[] List:ListFromExcel) {
            ListTransactions.add(Arrays.toString(List));
        }
        SendDataToDataBase(ListTransactions);
    }
    private static void SendDataToDataBase(List<String> ListTransactions){
        //Send(list)
    }


}
