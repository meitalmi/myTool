package com.mytool.interfaces;

import com.mytool.models.MySheet;

public interface IChangedRowsReporter {

    void reportAllChangedRows(MySheet oldSheet, MySheet newSheet);
}
