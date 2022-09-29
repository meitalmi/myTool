package tools;

import org.apache.poi.ss.usermodel.Row;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK;

public class MyRow {
    private Row row;

    public MyRow(Row row) {
        this.row = row;
    }

    public Row getRow() {
        return row;
    }

    public boolean isEquals(Row row) {
        if (this.row.getPhysicalNumberOfCells() != row.getPhysicalNumberOfCells())
            return false;

        for (int i = 0; i < this.row.getPhysicalNumberOfCells(); i++) {

            if (!CellUtils.isCellsEquals(
                    this.row.getCell(i, CREATE_NULL_AS_BLANK),
                    row.getCell(i, CREATE_NULL_AS_BLANK))) {
                return false;
            }
        }
        return true;
    }
}
