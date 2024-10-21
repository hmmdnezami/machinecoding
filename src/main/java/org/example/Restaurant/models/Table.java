package org.example.Restaurant.models;

public class Table {
    private int tableId;
    private boolean isOccupied;

    public Table(int tableId) {
        this.tableId = tableId;
        this.isOccupied= false;
    }

    public int getTableId() {
        return tableId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
