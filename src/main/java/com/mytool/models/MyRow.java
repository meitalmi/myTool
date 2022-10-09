package com.mytool.models;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import com.mytool.utils.CellUtils;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

public class MyRow {
    private Row row;

    public MyRow(Row row) {
        this.row = row;
    }

    public Row getRow() {
        return row;
    }

    public static String getIdOfRow(Row row, int keyColumn) {
        Cell id = row.getCell(keyColumn, CREATE_NULL_AS_BLANK);
        if (id == null || id.getCellType() == CellType.BLANK
                || id.getCellType() == CellType._NONE
                || id.getCellType() == CellType.ERROR)
            return null;

        String idStr = CellUtils.getCellValue(id);
        return idStr;
    }
}
