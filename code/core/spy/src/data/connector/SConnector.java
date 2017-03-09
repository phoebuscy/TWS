package data.connector;

import com.ib.controller.ApiConnection;
import com.ib.controller.ApiController;
import com.util.IConnectionConfiguration;

import javax.swing.*;
import java.util.ArrayList;


/**
 * Created by caiyong on 2017/2/25.
 */
public class SConnector implements ApiController.IConnectionHandler
{

    public static SConnector INSTANCE;
    private final IConnectionConfiguration m_connectionConfiguration;
    private ApiController m_controller;
    private final JTextArea m_inLog = new JTextArea();
    private final JTextArea m_outLog = new JTextArea();
    private final Logger m_inLogger = new Logger(m_inLog);
    private final Logger m_outLogger = new Logger(m_outLog);


    public static void main(String[] args)
    {
        start(new SConnector(new IConnectionConfiguration.DefaultConnectionConfiguration()));
    }

    public static void start(SConnector apiDemo)
    {
        INSTANCE = apiDemo;
        INSTANCE.run();
    }

    public SConnector(IConnectionConfiguration connectionConfig)
    {
        m_connectionConfiguration = connectionConfig;

    }
    public ApiController controller()
    {
        if (m_controller == null)
        {
            m_controller = new ApiController(this, getInLogger(), getOutLogger());
        }
        return m_controller;
    }
    public ApiConnection.ILogger getInLogger()
    {
        return m_inLogger;
    }

    public ApiConnection.ILogger getOutLogger()
    {
        return m_outLogger;
    }


    private void run()
    {
        // make initial connection to local host, port 7496, client id 0, no connection options
        controller().connect("127.0.0.2", 7496, 111,
                             m_connectionConfiguration.getDefaultConnectOptions() != null ? "" : null);
    }


    @Override
    public void connected()
    {

    }

    @Override
    public void disconnected()
    {

    }

    @Override
    public void accountList(ArrayList<String> list)
    {

    }

    @Override
    public void error(Exception e)
    {

    }

    @Override
    public void message(int id, int errorCode, String errorMsg)
    {

    }

    @Override
    public void show(String string)
    {

    }


    private static class Logger implements ApiConnection.ILogger
    {
        final private JTextArea m_area;

        Logger(JTextArea area)
        {
            m_area = area;
        }

        @Override
        public void log(final String str)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    //					m_area.append(str);
                    //
                    //					Dimension d = m_area.getSize();
                    //					m_area.scrollRectToVisible( new Rectangle( 0, d.height, 1, 1) );
                }
            });
        }
    }
}
