package com.view.panel.smallPanel;

import com.util.GBC;

import javax.swing.*;
import java.awt.*;

import static com.util.SUtil.getDimension;

/**
 * Created by caiyong on 2016/12/24.
 */
public class SOperateButtonPnl extends JPanel
{

    private Component parentWin;
    private Dimension parentDimension;

    private JButton callBtn = new JButton("CALL 开");
    private JButton callPutChangeBtn = new JButton("平反");
    private JButton putBtn = new JButton("PUT 开");

    public SOperateButtonPnl(Component parentWin)
    {
        setBackground(Color.blue);
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();
        buildGUI();

    }

    private void setDimension()
    {
        setSize(getDimension(parentDimension,1.0,0.51));
    }


    private void buildGUI()
    {
        setLayout(new GridBagLayout());
        add(callBtn, new GBC(0,0).setAnchor(GBC.WEST).setIpad(10,10).setInsets(0,20,0,30).setWeight(1,10).setFill(GBC.BOTH));
        add(callPutChangeBtn, new GBC(1,0).setAnchor(GBC.WEST).setIpad(10,10).setInsets(0,20,0,30).setWeight(1,10).setFill(GBC.BOTH));
        add(putBtn, new GBC(2,0).setAnchor(GBC.WEST).setIpad(10,10).setInsets(0,20,0,30).setWeight(1,10).setFill(GBC.BOTH));
    }


}
