package app;

public interface TableData {
    int getRows();
    int getCols();
    Object get(int row, int col);
    String getTitle(int col);
    int getWidth(int col);
}