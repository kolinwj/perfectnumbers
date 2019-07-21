package codechallenge.perfectnumbers.init;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import codechallenge.perfectnumbers.validation.NumberRangeValidation;
import codechallenge.perfectnumbers.validation.NumberValidation;
import codechallenge.perfectnumbers.resource.PerfectNumbersImpl;

import java.util.Arrays;

/**
 * @author kolin
 *  Initializing service and cxf JAXRSServer factoryBean
 */
public class RestServer {

	private static final Logger logger = LogManager.getLogger(RestServer.class);

	private JAXRSServerFactoryBean factoryBean;

	public RestServer initializeServer(final ConfigUtility config) {
		logger.info("Initializing server ");
		factoryBean = new JAXRSServerFactoryBean();

		factoryBean.setResourceProviders(
				Arrays.asList(
						new SingletonResourceProvider(new PerfectNumbersImpl())
						)
				);
		factoryBean.setProviders(
				Arrays.asList(
						new NumberRangeValidation(),new NumberValidation(),
						new JacksonJsonProvider()
						
						)
				);

		factoryBean.setAddress(config.getProperty("url.endpoint"));

		logger.info("Server initialize completed");

		return this;
	}

	public Server start() {
		Server server = factoryBean.create();
		return server;
	}

}
