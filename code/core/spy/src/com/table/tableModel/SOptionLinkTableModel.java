package com.table.tableModel;

import javax.swing.table.AbstractTableModel;

/**
 * Created by 123 on 2016/12/24.
 */
public class SOptionLinkTableModel extends AbstractTableModel
{

    private String[] columnNames = {"行权价", "CALL/PUT","最新价", "涨跌额", "涨跌幅", "卖一", "买一", "成交量", "未平仓"};
    private Object[][] data = {
            {255.50, "CALL涨", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
            {255.50, "PUT跌",2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
            {256.00, "CALL涨",2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
            {256.00, "PUT跌",2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436}};

    public SOptionLinkTableModel()
    {


    }

    @Override
    public int getRowCount()
    {
        return data.length;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data[rowIndex][columnIndex];
    }

    public void updateData(Object[][] tableData)
    {
        data = tableData;
    }



}
