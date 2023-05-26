package com.kxrucf.windchill.gui;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.List;

public class FileTableModel extends AbstractTableModel
{
    private final List<File> files;

    public FileTableModel(List<File> files)
    {
        this.files = files;
    }

    @Override
    public int getRowCount()
    {
        return files.size();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        return switch (columnIndex) {
            case 0 -> "Name";
            case 1 -> "File Type";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        File file = files.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> file.getName();
            case 1 -> getFileExtension(file.getName());
            default -> null;
        };
    }

    private static String getFileExtension(String fileName)
    {
        int dotIndex = fileName.lastIndexOf('.');
        String ext = (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);

        return switch (ext) {
            case "prt" -> "Creo Part File";
            default -> "Unknown File Type";
        };
    }
}
