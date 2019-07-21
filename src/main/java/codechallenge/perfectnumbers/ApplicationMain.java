package codechallenge.perfectnumbers;


import codechallenge.perfectnumbers.init.ConfigUtility;
import codechallenge.perfectnumbers.init.RestServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @main executor of the perfect number computation REST service
 * @version V1 
 * @create on 20th July 2019
 * @author kolin  
 */
public class ApplicationMain {
	
	
	 private static final Logger logger = LogManager.getLogger(ApplicationMain.class);

	public static void main(String[] args) {
		
		logger.info(" Init application ..");
		
		ConfigUtility conf=ConfigUtility.getInstance();
		
		RestServer server = new RestServer();
		
		logger.info(" Starting up Jetty instance ...");
        
		server.initializeServer(conf).start();

        logger.info(" Service is up. Ready to use with URL end point ", conf.getProperty("url.endpoint"));
		
	}
}
