package com.mytool.interfaces;

import com.mytool.models.MySheet;

public interface IAddedRowsReporter {

    void reportAddedRows(MySheet oldSheet, MySheet newSheet);
}
