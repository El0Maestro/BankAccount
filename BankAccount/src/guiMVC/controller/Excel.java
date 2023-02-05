package guiMVC.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import guiMVC.view.GUI;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static List<String[]> getDataFromExcel() {
        List<String[]> rowData = new ArrayList<>();
        try {
            File file = new File(String.valueOf(GUI.choosedFile));
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] cellData = new String[row.getLastCellNum()];
                int i = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING -> cellData[i] = cell.getStringCellValue();
                        case Cell.CELL_TYPE_NUMERIC -> {
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                                cellData[i] = dateFormat.format(cell.getDateCellValue());
                            } else {
                                cellData[i] = String.valueOf(cell.getNumericCellValue());
                            }
                        }
                        default -> cellData[i] = "";
                    }
                    i++;
                }
                rowData.add(cellData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowData;

    }
}