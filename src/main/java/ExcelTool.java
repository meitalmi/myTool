import com.*;
import com.interfaces.ITool;
import com.interfaces.reporters.IAddedRowsReporter;
import com.interfaces.reporters.IChangedRowsReporter;
import com.interfaces.reporters.IDeletedRowsReporter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.models.MySheet;

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
