import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConnectToData {

    public static void SendInfromationToExcel(/*String Path*/){
        String Path = "Plik_bankowy.xlsx";
        //informacja(path);
    }

    public static void SendDataToGUI(/*tablica[] tab || list*/){
        //Wysylam do GUI z DB
    }


    public static void ReceivingDataFromExcel(/*tablica[] tab*/){
        //przetwarzam dane i wysylam daty do sortowania(lub zmiany)
    }

    private static void SortingDates(/*List<String> dates || tablica[] */){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        try
        {
            /*for (String sorted:dates) {
                formatter.parse(sorted);
                //Date.add(sorted);
            }*/
        }catch (Exception e){
            System.out.println("ERROR date is Invalid");
        }
    }
    private static void SendSortedDataToDataBase(){
        //wszystko posortowane wysylam do DB
    }


}
