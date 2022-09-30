package com.interfaces.reporters;

import com.models.MySheet;

public interface IAddedRowsReporter {

    void reportAddedRows(MySheet oldSheet, MySheet newSheet);
}
