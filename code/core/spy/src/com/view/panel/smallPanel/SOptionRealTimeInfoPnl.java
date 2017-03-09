package com.view.panel.smallPanel;

import javax.swing.*;
import java.awt.*;

import static com.util.SUtil.getDimension;

/**
 * Created by caiyong on 2016/12/25.
 */
public class SOptionRealTimeInfoPnl extends JPanel
{
    private Component parentWin;
    private Dimension parentDimension;
    private int putOrCall = -1;

    public SOptionRealTimeInfoPnl(Component parentWin, int putOrCall)
    {
        setBackground(Color.gray);
        this.putOrCall = putOrCall;
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();
        buildGUI();

    }

    private void setDimension()
    {
        setSize(getDimension(parentDimension,1.0,0.1));
    }


    private void buildGUI()
    {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(putOrCall == 1? "CALL涨":"PUT跌"));

        /*
        SExpireDatePnl expireDatePanel = new SExpireDatePnl(this, getSize());
        SOptionTablePnl sOptionTablePnl = new SOptionTablePnl(this, getSize());

        add(expireDatePanel, new GBC(0, 0).setAnchor(GBC.WEST).setIpad(100, 5).setWeight(10, 2)
                                          .setFill(GBC.HORIZONTAL));
        add(sOptionTablePnl, new GBC(0, 1).setAnchor(GBC.WEST).setIpad(100, 70).setWeight(10, 70).setFill(GBC.BOTH));
        */
    }

    /**
     * 面板,在上面一行，包括 标的，行权日，行权价
     * @param obj
     * @param expireData
     * @param operatePrice
     * @return
     */
    private JPanel crtObjPnl(String obj, String expireData, String operatePrice)
    {
        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        pnl.add(new JLabel(obj));
        pnl.add(new JLabel("行权日: " + expireData));
        pnl.add(new JLabel("行权价: " + operatePrice));
        return pnl;
    }

    private JPanel crtRealTimePricePnl(String realTimePrice, String todayOpenPrice)
    {
        JPanel pnl = new JPanel(new GridBagLayout());

        return pnl;
    }




}
