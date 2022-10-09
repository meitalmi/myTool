package com.mytool.tools;

import com.mytool.excelobjects.ExcelReporter;
import com.mytool.interfaces.IDeletedRowsReporter;
import com.mytool.interfaces.ITool;
import com.mytool.interfaces.IAddedRowsReporter;
import com.mytool.interfaces.IChangedRowsReporter;
import com.mytool.models.MySheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTool implements ITool {
    public static final String OLD_FILE_NAME = "קובץ משרות.xlsx";

    @Override
    public void run() {
        printFileChanges();
    }

    public void printFileChanges() {
        try {

            File currDir = new File(OLD_FILE_NAME);
            String path = currDir.getAbsolutePath();

            FileInputStream file = new FileInputStream((path));
            Workbook workbook = new XSSFWorkbook(file);

            MySheet oldSheet = new MySheet(workbook.getSheetAt(0));
            MySheet newSheet = new MySheet(workbook.getSheetAt(1));

            IDeletedRowsReporter deletedReporter = new ExcelReporter();
            IAddedRowsReporter addReporter = new ExcelReporter();
            IChangedRowsReporter changedReporter = new ExcelReporter();

            deletedReporter.reportDeletedRows(oldSheet, newSheet);
            addReporter.reportAddedRows(oldSheet, newSheet);
            changedReporter.reportAllChangedRows(oldSheet, newSheet);

        } catch (FileNotFoundException exe) {
            exe.printStackTrace();
        } catch (IOException exe) {
            exe.printStackTrace();
        }
    }
}
