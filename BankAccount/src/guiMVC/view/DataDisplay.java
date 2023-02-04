package guiMVC.view;

import java.util.List;

public class DataDisplay {
    public static void displayData(List<String[]> data) {
        int columnCount = data.get(0).length;
        StringBuilder rowSeparator = new StringBuilder();
        for (int i = 0; i < columnCount; i++) {
            rowSeparator.append("+-----------------");
        }
        rowSeparator.append("+");

        System.out.println(rowSeparator);
        for (String[] rowData : data) {
            System.out.print("|");
            for (String cellData : rowData) {
                System.out.printf(" %-15s |", cellData);
            }
            System.out.println();
            System.out.println(rowSeparator);
        }
    }
}

