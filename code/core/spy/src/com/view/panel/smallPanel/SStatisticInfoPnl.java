package com.view.panel.smallPanel;

import javax.swing.*;
import java.awt.*;

import static com.util.SUtil.getDimension;

/**
 * Created by caiyong on 2016/12/25.
 */
public class SStatisticInfoPnl extends JPanel
{

    private Component parentWin;
    private Dimension parentDimension;

    public SStatisticInfoPnl(Component parentWin)
    {
        setBackground(Color.gray);
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();
        buildGUI();

    }

    private void setDimension()
    {
        setSize(getDimension(parentDimension,0.5,0.3));
    }


    private void buildGUI()
    {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("统计"));

        /*
        SExpireDatePnl expireDatePanel = new SExpireDatePnl(this, getSize());
        SOptionTablePnl sOptionTablePnl = new SOptionTablePnl(this, getSize());

        add(expireDatePanel, new GBC(0, 0).setAnchor(GBC.WEST).setIpad(100, 5).setWeight(10, 2)
                                          .setFill(GBC.HORIZONTAL));
        add(sOptionTablePnl, new GBC(0, 1).setAnchor(GBC.WEST).setIpad(100, 70).setWeight(10, 70).setFill(GBC.BOTH));
        */


    }

}
