/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pert4_50422904.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTableMahasiswa extends AbstractTableModel{

private List<ModelMahasiswa> mahasiswaList;
    private final String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};

    public ModelTableMahasiswa(List<ModelMahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getRowCount() {
        return mahasiswaList.size(); // Jumlah baris sesuai dengan jumlah data mahasiswa
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelMahasiswa mahasiswa = mahasiswaList.get(rowIndex);
    return switch (columnIndex) {
        case 0 -> mahasiswa.getId();
        case 1 -> mahasiswa.getNpm();
        case 2 -> mahasiswa.getNama();
        case 3 -> mahasiswa.getSemester();
        case 4 -> mahasiswa.getIpk();
        default -> null;
    };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}
