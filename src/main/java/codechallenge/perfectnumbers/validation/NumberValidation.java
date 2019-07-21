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
 * Request parameter validation
 */

@Provider
@Priority(value=1)
public class NumberValidation implements ContainerRequestFilter {

    private static final Logger logger = LogManager.getLogger(NumberValidation.class);

    @Override
    public void filter(ContainerRequestContext requestContext) {
 
      
        MultivaluedMap<String, String> parameters = requestContext.getUriInfo().getPathParameters();
        String numberValidityCheckRegexPattern="[\\d]*";

        if (parameters.size() > 0) {
        	
        	ConfigUtility conf=ConfigUtility.getInstance();

            String number = parameters.getFirst("number");
            
            Response response = null;
            Response.ResponseBuilder responseBuilder = null;

            if (number == null || "".equals(number)) {
                ErrorMessage errorMessage = new ErrorMessage(conf.getProperty("api.error.code.3"), Response.Status.BAD_REQUEST.getStatusCode());
                responseBuilder = Response.status(Response.Status.BAD_REQUEST);
                responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);
                response = responseBuilder.entity(errorMessage).build();
                requestContext.abortWith(response);
                
            } else if(!number.matches(numberValidityCheckRegexPattern)) {
                ErrorMessage errorMessage = new ErrorMessage(conf.getProperty("api.error.code.4"), Response.Status.BAD_REQUEST.getStatusCode());
                responseBuilder = Response.status(Response.Status.BAD_REQUEST);
                responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);
                response = responseBuilder.entity(errorMessage).build();
                requestContext.abortWith(response);
                
            } else {
                logger.info(" Parameters are valid  : recieved number is ", number);
            }
        }

    }

}