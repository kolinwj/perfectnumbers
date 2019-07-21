package codechallenge.perfectnumbers.integration;

import org.apache.cxf.endpoint.Server;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import codechallenge.perfectnumbers.init.ConfigUtility;
import codechallenge.perfectnumbers.init.RestServer;

/**
 * @author kolin
 * Firing embedded Jetty instance, use HTTP Client to send test requests 
 */
public class RestAPIIntegrationTest {

    static CloseableHttpClient client;
    static Server server;
    static String URL="";
    static ConfigUtility conf;

    @BeforeClass
    public static void setupClass() {
    	
    	conf = ConfigUtility.getInstance();
    	
    	URL=conf.getProperty("test.url.endpoint");

        server = new RestServer().initializeServer(conf).start();

        client = HttpClients.createDefault();
    }

    @AfterClass
    public static void teardownClass() throws IOException {
        client.close();
        if (server.isStarted()) {
            server.stop();
        }
    }

}