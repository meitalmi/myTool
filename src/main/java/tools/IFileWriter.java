package tools;

public interface IFileWriter<ROW, SHEET> {

    void writeIntoFile(ROW row);

    void writeIntoFile(ROW beforeRow, ROW afterRow);

    void writeFirstRow(SHEET sheet);
}

