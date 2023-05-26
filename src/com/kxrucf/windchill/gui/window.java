package com.kxrucf.windchill.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class window
{
    private static final String SERVER_PATH = "C:\\Users\\koppj\\Desktop\\TEST-SERVER";

    private JPanel panel1;
    private JScrollPane scrollPane;
    private JTable fileTable;

    public window()
    {
        updateFileBrowser();
    }

    private void updateFileBrowser()
    {
        File serverDir = new File(SERVER_PATH);
        ArrayList<File> files = new ArrayList<>(Arrays.asList(serverDir.listFiles()));

        TableModel fileTableModel = new FileTableModel(files);
        fileTable.setModel(fileTableModel);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("window");
        frame.setContentPane(new window().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
