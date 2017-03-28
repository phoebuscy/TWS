package example.loger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by caiyong on 2017/3/29.
 */
public class TLog4j2Test
{
    private static Logger logger = LogManager.getLogger(TLog4j2Test.class.getName());

    public static void main(String[] args)
    {
        int b = 1;
        for(int i = 0; i < 100000; i++)
        {
            logger.trace("trace level");
            logger.debug("debug level");
            logger.info("info level");
            logger.warn("warn level");
            logger.error("error level");
            logger.fatal("fatal level");
        }
        int a = 1;
    }
}
