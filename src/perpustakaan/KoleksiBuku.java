/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KoleksiBuku<T> extends AbstractTableModel {
    private List<T> list = new ArrayList<>();
    private String[] columnNames = {"Judul Buku", "Pengarang", "Tahun Terbit"};

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T item = list.get(rowIndex);
        if (item instanceof Buku) {
            Buku buku = (Buku) item;
            switch (columnIndex) {
                case 0: return buku.getJudul();
                case 1: return buku.getPengarang();
                case 2: return buku.getTahunTerbit();
                default: return null;
            }
        }
        return null;
    }

    // Method untuk menambahkan data
    public void add(T item) {
        list.add(item);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    // Method untuk menghapus data
    public void remove(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    // Method untuk mengosongkan data
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    // Generic method untuk menampilkan semua data
    public <U> void displayAll(List<U> items) {
        for (U item : items) {
            System.out.println(item);
        }
    }

    // Wildcard method untuk menambahkan semua data dari koleksi lain
    public void addAll(List<? extends T> items) {
        list.addAll(items);
        fireTableDataChanged();
    }
}