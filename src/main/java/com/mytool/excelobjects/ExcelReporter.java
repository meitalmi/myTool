package com.mytool.excelobjects;

import com.mytool.interfaces.IAddedRowsReporter;
import com.mytool.interfaces.IChangedRowsReporter;
import com.mytool.interfaces.IDeletedRowsReporter;
import com.mytool.models.MySheet;
import com.mytool.utils.SheetUtils;

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
