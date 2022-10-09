package com.mytool.utils;

import com.mytool.excelobjects.ExcelWriter;
import com.mytool.models.MySheet;
import org.apache.poi.ss.usermodel.Row;

public class SheetUtils {

    public static void printDeletedRows(MySheet oldSheet, MySheet newSheet, ExcelWriter fileWriter) {
        fileWriter.writeFirstRow(oldSheet);

        for (String id : oldSheet.getRows().keySet()) {
            if (!newSheet.getRows().containsKey(id)) {
                //the row deleted
                fileWriter.writeIntoFile(oldSheet.getRows().get(id));
            }
        }
    }

    public static void printAddedRows(MySheet oldSheet, MySheet newSheet, ExcelWriter fileWriter) {
        printDeletedRows(newSheet, oldSheet, fileWriter);
    }

    public static void printChangedRows(MySheet oldSheet, MySheet newSheet, ExcelWriter fileWriter) {
        fileWriter.writeFirstRow(newSheet);

        for (String id : newSheet.getRows().keySet()) {
            Row oldRow = oldSheet.getRows().get(id);
            Row newRow = newSheet.getRows().get(id);

            if (!RowUtils.isRowsEquals(oldRow, newRow)) {
                if (newRow != null && oldRow != null) {
                    fileWriter.writeIntoFile(oldRow, newRow);
                }
            }
        }
    }
}