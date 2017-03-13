package com.view.dialog;

import com.util.SUtil;
import com.view.panel.STopoFramContentPnl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 123 on 2016/12/18.
 */
public class SMainFram extends JFrame
{
    public static void main(String[] args)
    {
        SMainFram sMainFram = new SMainFram();
        sMainFram.setVisible(true);
    }

    public SMainFram()
    {
        buildTopoFrame();
    }

    private void buildTopoFrame()
    {
        /*
        String conffile = getSPYCONFIGFILE();
        String pathSepa = java.io.File.separator;  // 文件分割符号
        String filename = "spy.par/conf/" + TConst.SPY_CONFIG_FILE;
        List<String> fileLst = getProjectFileByName(filename);
        fileLst = getProjectFileByDoxName("png");
        String p = getCanPath();
        String pth = getCanonicalPath(".");
        fileLst = getFileDirectory(pth, TConst.TFileDirEnum.FILE_FLAG, true);
        String projPth = getProjectPath();
        String realPth = getRealPath();
        String appPath = getAppPath(SMainFram.class);
        */


        Dimension guiDim = SUtil.getGUIDimension((double) 4 / 5, (double) 4 / 5);
        setSize(guiDim);
        SUtil.showInScreenCenter(this, guiDim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new STopoFramContentPnl(this));
        SUtil.setWindosStyle(this, 1);

    }


}
