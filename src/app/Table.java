package app;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private TableData data;
    private char rolSeparator = '-';
    private char colSeparator = '|';

    public Table(TableData data) {
        this.data = data;
    }

    private void printLine(int w) {
        for (int i = 0; i < w; i++) {
            System.out.print(rolSeparator);
        }
        System.out.println();
    }
    public void print() {
        StringBuilder title = new StringBuilder();
        title.append(colSeparator);
        for (int c = 0; c < data.getCols(); c++) {
            title.append(String.format(" %" + data.getWidth(c) + "s %s", data.getTitle(c), colSeparator));
        }
        printLine(title.length());
        System.out.println(title);
        printLine(title.length());

        for (int r = 0; r < data.getRows(); r++) {
            System.out.print(colSeparator);
            for (int c = 0; c < data.getCols(); c++) {
                System.out.printf(" %" + data.getWidth(c) + "s %s", data.get(r, c), colSeparator);
            }
            System.out.println();
        }
        printLine(title.length());
    }
}