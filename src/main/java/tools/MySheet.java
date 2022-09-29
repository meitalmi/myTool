package tools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySheet {
    public static final List<String> KEY_VALUE_OPTIONS = Arrays.asList("הסניף", "סניף");
    public static Integer KEY_COLUMN = null;
    private Sheet sheet;
    private Map<String, Row> map = null;

    public MySheet(Sheet sheet) {
        this.sheet = sheet;
        findKeyColumn();
    }

    public Integer findKeyColumn() {
        if (KEY_COLUMN != null)
            return KEY_COLUMN;

        for (String keyValueOption : KEY_VALUE_OPTIONS) {
            for (Row row : this.sheet) {
                Integer keyColumn = RowUtils.findKeyColumn(row, keyValueOption);
                if (keyColumn != null) {
                    KEY_COLUMN = keyColumn;
                    return keyColumn;
                }
            }
        }
        return null;
    }

    //rowId, Row Object
    public Map<String, Row> getRows() {
        if (this.map != null) {
            return this.map;
        }
        this.map = new HashMap<>();

        for (Row row : this.sheet) {
            String id = RowUtils.getIdOfRow(row, KEY_COLUMN);
            if (id != null) {
                id = id.replaceAll("\\s+", "");
            }
            map.put(id, row);
        }
        return map;
    }


    public boolean isRowExists(Row row) {
        String id = RowUtils.getIdOfRow(row, KEY_COLUMN);
        return this.getRows().containsKey(id);
    }

    public Row getFirstRow(List<String> idsOptions) {
        for (String idOption : idsOptions) {
            if (getRows().containsKey(idOption)) {
                return getRows().get(idOption);
            }
        }
        return null;
    }

    public boolean isRowExists(String rowId) {
        return this.getRows().containsKey(rowId);
    }

}
