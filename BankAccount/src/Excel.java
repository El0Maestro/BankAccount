import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel extends GUI {
    public static void main(String[] args) throws IOException {


        String exceleFilePath = "Plik_bankowy.xlsx";

            FileInputStream file = new FileInputStream(exceleFilePath);
            //FileInputStream file = new FileInputStream(GUI.file);
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Pobieranie arkusza excel
            XSSFSheet sheet= workbook.getSheetAt(0);//druga opcja na pobranie arkusza XSSFSheet sheet= workbook.getSheet("Arkusz1");

            //użycie pętli for
        int rows = sheet.getLastRowNum();//pobieranie ilości wierszy w excelu
        int columns = sheet.getRow(1).getLastCellNum();//pobieranie ilości kolumn excel
        for (int r=0; r<=rows; r++)//zaczynamy od wiersza na indexie 0, wykonuje do ilości pobranych wierszy, i podnosimy po każdej iteracji pętli
        {
            XSSFRow row = sheet.getRow(r);

            for (int c=0; c<columns; c++){

                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()){
                    case STRING -> {
                        System.out.println(cell.getStringCellValue());
                        break;
                    }
                    case NUMERIC -> {
                        System.out.println(cell.getNumericCellValue());
                        break;
                    }
                }

            }
            System.out.println();
        }






    }
}