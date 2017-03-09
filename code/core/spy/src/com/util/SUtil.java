package com.util;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * Created by 123 on 2016/12/18.
 */
public class SUtil
{


    /**
     * 获取到屏幕长宽相对比列的尺寸, 参数不能大于1
     *
     * @param rel_width  宽的相对比例
     * @param rel_height 高的相对比例
     * @return 计算后的dimension
     */
    public static Dimension getGUIDimension(double rel_width, double rel_height)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDim = toolkit.getScreenSize();
        double width = rel_width >= 1.0 ? 1.0 : rel_width;
        double height = rel_height >= 1.0 ? 1.0 : rel_height;
        return new Dimension((int) (screenDim.width * width), (int) (screenDim.height * height));
    }

    public static Dimension getParentDimension(Dimension parentDim)
    {
        return (parentDim != null) ? parentDim : Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static void showInScreenCenter(Component frame, Dimension framDim)
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDim = toolkit.getScreenSize();

        int centerX = screenDim.width * 1 / 2;
        int centerY = screenDim.height * 1 / 2;

        int showX = centerX - framDim.width * 1 / 2;
        int showY = centerY - framDim.height * 1 / 2;

        frame.setLocation(showX, showY);
    }

    public static Dimension getScreenCenterLocation()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenDim = toolkit.getScreenSize();

        int centerX = screenDim.width * 1 / 2;
        int centerY = screenDim.height * 1 / 2;
        return new Dimension(centerX, centerY);
    }


    public static Dimension getDimension(Dimension dim, double rel_width, double rel_height)
    {
        if (dim != null && rel_width >= 0.0 && rel_width <= 1.0)
        {
            return new Dimension((int) (dim.width * rel_width), (int) (dim.height * rel_height));
        }
        return null;
    }

    public static void setWindosStyle(JFrame topoframe, int style)
    {

        String sty = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
        switch (style)
        {
            case 1:
                sty = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";//Nimbus风格，jdk6 update10版本以后的才会出现
                break;
            case 2:
                sty = UIManager.getSystemLookAndFeelClassName();//当前系统风格
                break;
            case 3:
                sty = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";//Motif风格，是蓝黑
                break;
            case 4:
                sty = UIManager.getCrossPlatformLookAndFeelClassName();//跨平台的Java风格
                break;
            case 5:
                sty = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";//windows风格
                break;
            case 6:
                sty = "javax.swing.plaf.windows.WindowsLookAndFeel";//windows风格
                break;
            case 7:
                sty = "javax.swing.plaf.metal.MetalLookAndFeel";//java风格
                break;
            case 8:
                sty = "com.apple.mrj.swing.MacLookAndFeel";//待考察，
                break;
        }
        try
        {
            UIManager.setLookAndFeel(sty);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(topoframe.getContentPane());
    }

    public static JButton crtButton(String buttTxt)
    {
        JButton btn = new JButton(buttTxt);
        return btn;
    }

    public static void setColumWidth(JTable table, int width,int height)
    {
        if(table != null)
        {
            TableColumnModel tableColumnModel = table.getColumnModel();
            int clumCount = tableColumnModel.getColumnCount();
            for(int i = 0; i < clumCount; i++)
            {
                tableColumnModel.getColumn(i).setPreferredWidth(width);
            }
            table.setRowHeight(height);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }

    }


}
