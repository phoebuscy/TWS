package com.view.panel.smallPanel;

import com.enums.SCallOrPut;
import com.util.Cst;
import com.util.GBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.TIconUtil.getProjIcon;
import static com.util.SUtil.getDimension;
import static com.util.SUtil.isIntOrDoubleNumber;

/**
 * Created by caiyong on 2016/12/24.
 */
public class SOperateButtonPnl extends JPanel
{

    private Component parentWin;
    private Dimension parentDimension;

    private OpenCloseButton callBtn = new OpenCloseButton(SCallOrPut.CALL); //  JButton("CALL 开");
    private ChangeOperateButton callPutChangeBtn = new ChangeOperateButton();
    private OpenCloseButton putBtn = new OpenCloseButton(SCallOrPut.PUT); //JButton("PUT 开");

    public SOperateButtonPnl(Component parentWin)
    {
        setBackground(Color.gray);
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();
        buildGUI();
    }


    private void setDimension()
    {
        setPreferredSize(getDimension(parentDimension, 0.5, 0.2));
    }


    private void buildGUI()
    {
        setLayout(new GridBagLayout());
        add(callBtn, new GBC(0, 0).setAnchor(GBC.WEST).setIpad(10, 10).setInsets(0, 20, 0, 30).setWeight(1, 10)
                                  .setFill(GBC.BOTH));
        add(callPutChangeBtn, new GBC(1, 0).setAnchor(GBC.WEST).setIpad(10, 10).setInsets(0, 20, 0, 30).setWeight(1, 10)
                                           .setFill(GBC.BOTH));
        add(putBtn, new GBC(2, 0).setAnchor(GBC.WEST).setIpad(10, 10).setInsets(0, 20, 0, 30).setWeight(1, 10)
                                 .setFill(GBC.BOTH));
    }


    private class ChangeOperateButton extends JButton
    {
        private Icon changeIco = getProjIcon("change");

        public ChangeOperateButton()
        {
            setIcon(changeIco);
            setText("平/反");
            addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    callBtn.setProfit("500.2", "0.25");
                    putBtn.setProfit("-23", "-0.11");
                }
            });
        }
    }

    private class OpenCloseButton extends JButton
    {
        private SCallOrPut callOrPut;
        private double realAdd = 0.0;  // 实际收益
        private double percent = 0.0;   //收益百分比

        private Icon waitIco; // 还没开仓图标
        private Icon middleIco; // 收益为0图标
        private Icon gainLittle; // 盈利
        private Icon gainMore; // 更盈利
        private Icon lossLittle;  // 亏损一点
        private Icon lossMore;    // 亏损较多

        public OpenCloseButton(SCallOrPut callOrPut)
        {
            this.callOrPut = callOrPut;
            init();
        }

        public void setActionListerner()
        {
            addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    initIcon();
                }
            });
        }

        private void init()
        {
            waitIco =  getProjIcon("img5");     // 还没开仓图标
            middleIco = getProjIcon("img2");    // 收益为0图标
            gainLittle = getProjIcon("img3");   // 盈利
            gainMore = getProjIcon("img4");     // 更盈利
            lossLittle = getProjIcon("img1");   // 亏损一点
            lossMore = getProjIcon("img0");     // 亏损较多
            // “dialog”代表字体，1代表样式(1是粗体，0是平常的）15是字号设置字体
            //price.setFont(new java.awt.Font("Dialog",   1,   15));
            setPreferredSize(new Dimension(100,15));
            setFont(new java.awt.Font("Dialog", 1, 15));
            setIcon(waitIco);
            setText(callOrPut.toString() + "开仓");
            setActionListerner();
        }

        private void initIcon()
        {
            setIcon(waitIco);
            setText(callOrPut.toString() + "开仓");
        }

        public void setProfit(String realAddStr, String percentStr)
        {
            if (isIntOrDoubleNumber(realAddStr) && isIntOrDoubleNumber(percentStr))
            {
                double realAdd = Double.parseDouble(realAddStr);
                double percent = Double.parseDouble(percentStr);
                setFaceIcon(percent);
                setButProfitTxt(realAdd, percent);
            }
            else
            {
                initIcon();
            }
        }

        private void setButProfitTxt(double realAdd, double percent)
        {
            Color color = Color.black;
            if (percent > 0.0)
            {
                color = Cst.ReadColor;
            }
            else if (percent < 0.0)
            {
                color = Cst.GreenColor;
            }
            setForeground(color);
            String txt = String.format("%.2f  %.2f%% 平", realAdd, percent);
            setText(txt);
        }

        private void setFaceIcon(double percent)
        {
            Icon icon = middleIco;
            if (percent > 0.0 && percent < 0.05)
            {
                icon = gainLittle;
            }
            else if (percent > 0.05)
            {
                icon = gainMore;
            }
            else if (percent < 0.0 && percent > -0.05)
            {
                icon = lossLittle;
            }
            else if (percent < -0.05)
            {
                icon = lossMore;
            }
            setIcon(icon);
        }
    }


}
