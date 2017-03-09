package com.table;

import com.render.SRosePercentRender;
import com.render.SRoserender;
import com.table.tableModel.SOptionLinkTableModel;

import javax.swing.*;
import java.util.Random;

import static com.util.SUtil.setColumWidth;

/**
 * Created by caiyong on 2017/1/15.
 */
public class SOptionLinkTable extends JTable
{

    private SOptionLinkTableModel optionLinkTabelModel;

    public SOptionLinkTable()
    {
        optionLinkTabelModel = new SOptionLinkTableModel();
        setModel(optionLinkTabelModel);
        getColumnModel().getColumn(3).setCellRenderer(new SRoserender());
        getColumnModel().getColumn(4).setCellRenderer(new SRosePercentRender());
        setColumWidth(this, 80, 22);
    }


    public void updateData(Object[][] tableData)
    {
        optionLinkTabelModel.updateData(getTableData());
        optionLinkTabelModel.fireTableDataChanged();
    }


    private Object[][] getTableData()
    {

        Object[][] data1 = {{2552.50, "CALL涨", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {255.50, "PUT跌", 2.85, -3.2, -0.18, 2.89, 2.87, 5000, 23436},
                            {2561.00, "CALL涨", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {255.50, "PUT跌", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {2561.00, "CALL涨", 2.85, -1.2, -0.18, 2.89, 2.87, 5000, 23436},
                            {2561.00, "CALL涨", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {255.50, "PUT跌", 2.85, -3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {256.00, "PUT跌", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436}};

        Object[][] data2 = {{2553.50, "CALL涨", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {2561.00, "CALL涨", 2.85, +3.2, +0.18, 2.89, 2.87, 5000, 23436},
                            {255.50, "PUT跌", 2.85, 3.2, 0.18, 2.89, 2.87, 5000, 23436},
                            {2565.02, "PUT跌", 2.85, -3.2, -0.18, 2.89, 2.87, 5000, 23436}};

        Random random = new Random();
        boolean b = random.nextBoolean();

        return b ? data1 : data2;
    }


}
