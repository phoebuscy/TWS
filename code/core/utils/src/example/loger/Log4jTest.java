package example.loger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by caiyong on 2017/3/27.
 */
public class Log4jTest
{

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Log4jTest.class);
        PropertyConfigurator.configure("C:\\GitHubProj\\TWS\\log\\log4j.properties");
        log.debug("yes,debug");
        log.info("yes,info");
        log.error("yes,error");
        log.warn("yes,warn");
    }
}
