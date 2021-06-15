package ex42;

import java.util.List;

public class TableFormat {
    private List<Integer> columnSpan;

    public TableFormat(List<Integer> columnSpan) {
        this.columnSpan = columnSpan;
    }

    public List<Integer> getColumnSpan() {
        return columnSpan;
    }
}
