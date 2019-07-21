package codechallenge.perfectnumbers.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import codechallenge.perfectnumbers.exception.ErrorMessage;
import codechallenge.perfectnumbers.init.ConfigUtility;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author kolin
 * Request parameters validation
 */

@Provider
@Priority(value = 1)
public class NumberRangeValidation implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(NumberRangeValidation.class);

    @Override
    public void filter(ContainerRequestContext requestContext) {
    	
        MultivaluedMap<String, String> queryParams = requestContext.getUriInfo().getQueryParameters();
        String numberValidityCheckRegexPattern="[\\d]*";
      
        if (queryParams.size() > 0) {

        	ConfigUtility conf=ConfigUtility.getInstance();
        	
            String startNumber = queryParams.getFirst("startNumber");
            String endNumber = queryParams.getFirst("endNumber");
            
            Response response = null;
            Response.ResponseBuilder responseBuilder = null;

            if (startNumber == null || "".equals(startNumber) || endNumber == null || "".equals(endNumber)) {
            	
                ErrorMessage errorMessage = new ErrorMessage(conf.getProperty("api.error.code.1"), Response.Status.BAD_REQUEST.getStatusCode());
                responseBuilder = Response.status(Response.Status.BAD_REQUEST);
                responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);
                response = responseBuilder.entity(errorMessage).build();
                requestContext.abortWith(response);
                
            } else if(!startNumber.matches(numberValidityCheckRegexPattern) || !endNumber.matches(numberValidityCheckRegexPattern)) {
               
            	ErrorMessage errorMessage = new ErrorMessage(conf.getProperty("api.error.code.2"), Response.Status.BAD_REQUEST.getStatusCode());
                responseBuilder = Response.status(Response.Status.BAD_REQUEST);
                responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);
                response = responseBuilder.entity(errorMessage).build();
                requestContext.abortWith(response);
                
            } else
            {
                logger.info(" Parameters are valid : startNumber is ", startNumber," endNumber is ", endNumber);
            }
        }

    }
}