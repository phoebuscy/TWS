package example.loger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

import static com.TFileUtil.getProjectFileByName;
import static com.TPubUtil.notNullAndEmptyCollection;

/**
 * Created by caiyong on 2017/3/27.
 */
public class Log4jTest
{

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Log4jTest.class);
        List<String> logprop = getProjectFileByName("log4j.properties");
        if(notNullAndEmptyCollection(logprop))
        {
            PropertyConfigurator.configure(logprop.get(0));
        }
        log.debug("yes,debug");
        log.info("yes,info");
        log.error("yes,error");
        log.warn("yes,warn");


    }
}
