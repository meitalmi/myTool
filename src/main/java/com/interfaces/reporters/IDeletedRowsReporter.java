package com.interfaces.reporters;

import com.models.MySheet;

public interface IDeletedRowsReporter {

    void reportDeletedRows(MySheet oldSheet, MySheet newSheet);
}
