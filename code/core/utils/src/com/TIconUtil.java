package com;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.TPubUtil.notNullAndEmptyArry;
import static com.TStringUtil.notNullAndEmptyStr;

/**
 * Created by caiyong on 2017/3/11.
 */
public class TIconUtil
{

    public static void main(String[] args)
    {
        String path = "C:\\GitHubProj\\twsapi-client\\spy\\spy.par\\res\\picture";

        File file = new File(path);
        File[] tempList = file.listFiles();
        System.out.println("该目录下对象个数：" + tempList.length);
        for (int i = 0; i < tempList.length; i++)
        {
            if (tempList[i].isFile())
            {
                System.out.println("文     件：" + tempList[i].toString());
                String name = tempList[i].getName();
                System.out.println("name: " + name);
                String[] nameArr = name.split("\\.");
                System.out.println("pre  :" + nameArr[0] + "   next : " + nameArr[1]);
            }
            if (tempList[i].isDirectory())
            {
                System.out.println("文件夹：" + tempList[i]);
            }
        }
    }


    public static Map<String, Icon> getIconSource(String iconPath)
    {
        Map<String, Icon> iconMap = new HashMap<>();
        if (notNullAndEmptyStr(iconPath))
        {
            File file = new File(iconPath);
            File[] tempList = file.listFiles();
            if (notNullAndEmptyArry(tempList))
            {
                for (int i = 0; i < tempList.length; i++)
                {
                    if (tempList[i].isFile())
                    {
                        Icon icon = new ImageIcon(tempList[i].toString());
                        if (icon != null)
                        {
                            String name = tempList[i].getName();
                            String[] nameArr = name.split("\\.");
                            if (notNullAndEmptyArry(nameArr) && notNullAndEmptyStr(nameArr[0]))
                            {
                                iconMap.put(nameArr[0], icon);
                            }
                        }
                    }
                }
            }
        }

        return iconMap;
    }


}
