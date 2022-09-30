package com.interfaces.reporters;

import com.models.MySheet;

public interface IChangedRowsReporter {

    void reportAllChangedRows(MySheet oldSheet, MySheet newSheet);
}
