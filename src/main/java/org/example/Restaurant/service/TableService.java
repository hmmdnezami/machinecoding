package org.example.Restaurant.service;

import org.example.Restaurant.models.Table;

import java.util.HashMap;

public class TableService {

    private HashMap<Integer, Table> tables ;

    TableService(int totalTable) {
        tables = new HashMap<>() ;
        for (int i=1 ;i<=totalTable; i++) tables.put(i, new Table(i)) ;
    }

    public void addTable() {
        int newId = tables.size() + 1;
        tables.put(newId, new Table(newId));
    }

    public void removeTable(int tableId) {
        tables.remove(tableId);
    }

    public Table getTable(int tableId) {
        return tables.get(tableId);
    }
}
