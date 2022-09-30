package com;

import com.interfaces.reporters.IAddedRowsReporter;
import com.interfaces.reporters.IChangedRowsReporter;
import com.interfaces.reporters.IDeletedRowsReporter;
import com.models.MySheet;
import com.utils.SheetUtils;

public class ExcelReporter implements IAddedRowsReporter, IDeletedRowsReporter, IChangedRowsReporter {

    @Override
    public void reportAddedRows(MySheet mySheet1, MySheet mySheet2) {
        String fileName = "השורות שנוספו";
        ExcelWriter excelWriter = new ExcelWriter(fileName);

        SheetUtils.printAddedRows(mySheet1, mySheet2, excelWriter);

        excelWriter.end(fileName);
    }

    @Override
    public void reportDeletedRows(MySheet mySheet1, MySheet mySheet2) {
        String fileName = "השורות שנמחקו";
        ExcelWriter excelWriter = new ExcelWriter(fileName);

        SheetUtils.printDeletedRows(mySheet1, mySheet2, excelWriter);

        excelWriter.end(fileName);
    }

    @Override
    public void reportAllChangedRows(MySheet mySheet1, MySheet mySheet2) {
        String fileName = "השורות שהשתנו";
        ExcelWriter excelWriter = new ExcelWriter(fileName);

        SheetUtils.printChangedRows(mySheet1, mySheet2, excelWriter);

        excelWriter.end(fileName);
    }
}
