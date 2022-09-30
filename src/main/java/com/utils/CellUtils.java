package com.utils;

import org.apache.poi.ss.usermodel.Cell;

public class CellUtils {

    public static boolean isCellsEquals(Cell c1, Cell c2) {
        if (c1 == null && c2 == null) return true;
        if (c1 == null || c2 == null) return false;

        String cell1Str = getCellValue(c1);
        String cell2Str = getCellValue(c2);


        return cell1Str.equals(cell2Str);
    }

    public static String getCellValue(Cell cell) {
        String res = "";

        if (cell == null) return res;

        // Get cell data value
        switch (cell.getCellType()) {
            case BLANK:
                res = cell.getStringCellValue();
            case BOOLEAN:
                res = String.valueOf(cell.getBooleanCellValue());
                break;
            case ERROR:
                res = String.valueOf(cell.getErrorCellValue());
                break;
            case FORMULA:
                res = cell.getCellFormula();
                break;
            case NUMERIC:
                res = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                res = cell.getRichStringCellValue().getString();
                break;
        }

        return res.replaceAll("\\s+", "");
    }

    public static void setCellValue(Cell oldCell, Cell newCell) {
        if (oldCell == null) {
            newCell.setCellValue("");
            return;
        }

        // Set the cell data value
        switch (oldCell.getCellType()) {
            case BLANK -> newCell.setCellValue(oldCell.getStringCellValue());
            case BOOLEAN -> newCell.setCellValue(oldCell.getBooleanCellValue());
            case ERROR -> newCell.setCellErrorValue(oldCell.getErrorCellValue());
            case FORMULA -> newCell.setCellFormula(oldCell.getCellFormula());
            case NUMERIC -> newCell.setCellValue(oldCell.getNumericCellValue());
            case STRING -> newCell.setCellValue(oldCell.getRichStringCellValue());
            case _NONE -> newCell.setCellValue("");
        }
    }
}
