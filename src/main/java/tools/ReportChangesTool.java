package tools;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tools.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReportChangesTool implements ITool {
    public static final String OLD_FILE_NAME = "קובץ משרות.xlsx";
    public static final String NEW_FILE_NAME = "src/main/resources/file1.xlsx";
    public static final String FILE_TITLE = "src/main/resources/outputFile.xlsx";
    public static final String ERRORS_FILE_NAME = "src/main/resources/קובץ שגיאות.txt";

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
