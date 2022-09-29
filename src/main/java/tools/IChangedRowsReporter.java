package tools;

public interface IChangedRowsReporter {

    void reportAllChangedRows(MySheet oldSheet, MySheet newSheet);
}
