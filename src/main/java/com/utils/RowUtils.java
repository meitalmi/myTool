package com.utils;

import org.apache.poi.ss.usermodel.Row;
import com.models.MySheet;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;

public class RowUtils {

    public static boolean isRowsEquals(Row row1, Row row2) {
        if (row1 == null && row2 == null) return true;
        if (row1 == null || row2 == null) return false;

        if (row1.getPhysicalNumberOfCells() != row2.getPhysicalNumberOfCells())
            return false;

        for (int i = 0; i < row1.getPhysicalNumberOfCells(); i++) {
            if (!CellUtils.isCellsEquals(
                    row1.getCell(i, RETURN_NULL_AND_BLANK),
                    row2.getCell(i, RETURN_NULL_AND_BLANK))) {
                return false;
            }
        }
        return true;
    }

    public static Integer findKeyColumn(Row row, String keyValue) {
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            String cellValue = CellUtils.getCellValue(row.getCell(i));
            if (cellValue.equals(keyValue)) return i;
        }
        return null;
    }

    public Row getRowById(MySheet sheet, String id) {
        return sheet.getRows().get(id);
    }
}
