package com.mytool.interfaces;

import com.mytool.models.MySheet;

public interface IDeletedRowsReporter {

    void reportDeletedRows(MySheet oldSheet, MySheet newSheet);
}
