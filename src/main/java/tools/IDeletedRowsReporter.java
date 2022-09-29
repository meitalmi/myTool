package tools;

public interface IDeletedRowsReporter {

    void reportDeletedRows(MySheet oldSheet, MySheet newSheet);
}
