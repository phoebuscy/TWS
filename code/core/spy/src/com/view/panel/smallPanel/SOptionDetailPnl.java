package com.view.panel.smallPanel;

import com.util.GBC;

import javax.swing.*;
import java.awt.*;

import static com.util.SUtil.getDimension;

/**
 * Created by caiyong on 2016/12/24.
 */
public class SOptionDetailPnl extends JPanel
{

    private Component parentWin;
    private Dimension parentDimension;

    public SOptionDetailPnl(Component parentWin)
    {
        setBackground(Color.gray);
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();
        buildGUI();

    }

    private void setDimension()
    {
        setSize(getDimension(parentDimension,1.0,0.5));
    }


    private void buildGUI()
    {
        setLayout(new GridBagLayout());
        SOptionRealTimeInfoPnl callInfoPnl = new SOptionRealTimeInfoPnl(this, 1);
        SOptionRealTimeInfoPnl putInfoPnl = new SOptionRealTimeInfoPnl(this, 2);
        add(callInfoPnl, new GBC(0, 0).setAnchor(GBC.WEST).setIpad(100, 5).setWeight(10, 10).setFill(GBC.BOTH));
        add(putInfoPnl, new GBC(1, 0).setAnchor(GBC.EAST).setIpad(100, 5).setWeight(10, 10).setFill(GBC.BOTH));
    }

}
