package com.mytool.excelobjects;

import com.mytool.interfaces.IFileWriter;
import com.mytool.models.MyRow;
import com.mytool.models.MySheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.mytool.utils.CellUtils;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelWriter implements IFileWriter<MyRow, MySheet> {
    XSSFWorkbook workbook;

    public ExcelWriter(String sheetName) {
        this.workbook = new XSSFWorkbook();
        workbook.createSheet(sheetName);
        //sheet.setColumnWidth(0, 6000);
    }

    public void writeIntoFile(Row beforeRow, Row afterRow) {
        beforeRow.createCell(beforeRow.getPhysicalNumberOfCells())
                .setCellValue("(ישן)");
        afterRow.createCell(afterRow.getPhysicalNumberOfCells())
                .setCellValue("(חדש)");
        writeIntoFile(beforeRow);
        writeIntoFile(afterRow);
        writeEmptyRow();
    }

    @Override
    public void writeFirstRow(MySheet sheet) {
        Row firstRow = sheet.getFirstRow(MySheet.KEY_VALUE_OPTIONS);
        writeIntoFile(firstRow);
        if (firstRow == null) return; //TODO RETURN ERROR
    }

    public void writeEmptyRow() {
        int rowIndex = workbook.getSheetAt(0).getLastRowNum();
        Row newRow = workbook.getSheetAt(0).createRow(rowIndex + 1);
    }

    public void writeIntoFile(Row row) {
        if (row == null) return;

        int rowIndex = workbook.getSheetAt(0).getLastRowNum();

        Row newRow = workbook.getSheetAt(0).createRow(rowIndex + 1);

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = newRow.createCell(i);
            CellUtils.setCellValue(row.getCell(i, Row.MissingCellPolicy
                    .RETURN_NULL_AND_BLANK), cell);
        }
    }

    public void end(String fileName) {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();

        String fileLocation = path.substring(0, path.length() - 1) + fileName + ".xlsx";
        //String fileLocation = "C:/Users/User/Desktop/myApp/קבצים שנוצרו/" + fileName + ".xlsx";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeIntoFile(MyRow myRow) {
        writeIntoFile(myRow.getRow());
    }

    @Override
    public void writeIntoFile(MyRow beforeRow, MyRow afterRow) {
        writeIntoFile(beforeRow.getRow(), afterRow.getRow());
    }
}
