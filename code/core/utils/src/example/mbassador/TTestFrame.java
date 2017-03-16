package example.mbassador;

import com.ReturnObj;
import com.TMbassadorSingleton;
import net.engio.mbassy.listener.Filter;
import net.engio.mbassy.listener.Handler;
import net.engio.mbassy.listener.IMessageFilter;
import net.engio.mbassy.listener.Invoke;
import net.engio.mbassy.subscription.SubscriptionContext;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

import static com.SUtil.getGUIDimension;
import static com.SUtil.setWindosStyle;
import static com.SUtil.showInScreenCenter;

/**
 * Created by 123 on 2017/3/14.
 */
public class TTestFrame extends JFrame
{
    public static void main(String[] args)
    {
        TTestFrame sMainFram = new TTestFrame();
        sMainFram.setVisible(true);
    }

    public TTestFrame()
    {
        buildTopoFrame();
        TMbassadorSingleton.getInstance("myfirstBus").subscribe(this);
    }

    private void buildTopoFrame()
    {

        Dimension guiDim = getGUIDimension((double) 4 / 5, (double) 4 / 5);
        setSize(guiDim);
        showInScreenCenter(this, guiDim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindosStyle(this, 1);

    }

    @Handler
    public void synchronousHandler(Object message)
    {
        // do something
        if (message instanceof String)
        {
            int a = 1;
        }
        int b = 1;
    }


    @Handler(filters = {@Filter(ListenerDefinition.FilteringListener.MyBigIntegerfilter.class)})
    public void bigInterMessage(ReturnObj message)
    {
        int a = 1;

    }


}
