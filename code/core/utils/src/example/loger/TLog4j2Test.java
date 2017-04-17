package example.loger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by caiyong on 2017/3/29.
 */
public class TLog4j2Test
{
    private static Logger logger = LogManager.getLogger("msglog");
    private static Logger logger2 = LogManager.getLogger("");

    public static void main(String[] args)
    {
        int b = 1;
        for(int i = 0; i < 1000; i++)
        {
            logger.trace("trace level");
            logger.debug("debug level");
            logger.info("info level");
            logger.warn("warn level");
            logger.error("error level");
            logger.fatal("fatal level");


            logger2.trace("trace level2");
            logger2.debug("debug level2");
            logger2.info("info level2");
            logger2.warn("warn level2");
            logger2.error("error level2");
            logger2.fatal("fatal level2");
        }
        int a = 1;
    }
}
