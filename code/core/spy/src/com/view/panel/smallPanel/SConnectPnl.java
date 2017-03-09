package com.view.panel.smallPanel;

import com.util.SUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**  连接按钮面板
 * Created by 123 on 2016/12/19.
 */
public class SConnectPnl extends JPanel
{
    private Component parentWin;
    private Dimension parentDimension;

    private JLabel ip = new JLabel("IP:");
    private JTextField ipText = new JTextField("127.0.0.1", 10);
    private JLabel port = new JLabel("Port:");
    private JTextField portText = new JTextField("4002", 5);
    private JButton connectBtn = new JButton("Connect");
    private JLabel connStatus = new JLabel("Disconnect");


    public SConnectPnl(Component parentWin)
    {
        setBackground(Color.gray);
        this.parentWin = parentWin;
        parentDimension = parentWin.getSize();
        setDimension();

        buildGUI();
        setButtonListener();
    }

    private void setDimension()
    {
        setSize(SUtil.getDimension(parentDimension,1.0,0.1));
    }


    private void buildGUI()
    {
        setLayout(new FlowLayout(FlowLayout.LEFT, 15,0));
        add(ip);
        add(ipText);
        add(port);
        add(portText);
        add(connectBtn);
        add(connStatus);
        Icon icon = new ImageIcon("source/picture/disconnicon.png");
        connStatus.setIcon(icon);
    }

    private void setButtonListener()
    {
        if(connectBtn != null)
        {
            connectBtn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // 执行链接网关操作
                    Icon icon = new ImageIcon("source/picture/connicon.png");
                    connStatus.setIcon(icon);
                }
            });
        }
    }


}
