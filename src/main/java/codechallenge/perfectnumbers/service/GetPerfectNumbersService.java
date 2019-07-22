package codechallenge.perfectnumbers.service;

import javax.ws.rs.core.Response;
import java.util.List;
import codechallenge.perfectnumbers.exception.NumberRangeException;
import codechallenge.perfectnumbers.core.ComputePerfectNumbers;
import codechallenge.perfectnumbers.core.PerfectNumberList;
import codechallenge.perfectnumbers.exception.ErrorMessage;
import codechallenge.perfectnumbers.service.Parameters;


/**
 * @author kolin
 * 
 */

public class GetPerfectNumbersService implements IRestService<Parameters> {

    @Override
    public Response execute(Parameters params) {
        Response response = null;
        try {
        	
        	System.out.println(""+params.getStartNumber());
        	System.out.println(""+params.getEndNumber());
        	
            List<Long> resultslist = ComputePerfectNumbers.getPerfectNumbers(params.getStartNumber(), params.getEndNumber());
            PerfectNumberList perfectNumbersList = new PerfectNumberList();
            perfectNumbersList.setPerfectNumbersList(resultslist);

            response = Response.status(Response.Status.OK).entity(perfectNumbersList).build();
        } catch (NumberRangeException e) {
            ErrorMessage error = new ErrorMessage(e.getMessage(), Response.Status.BAD_REQUEST.getStatusCode());

            response = Response.status(Response.Status.BAD_REQUEST).entity(error).build();
        }

        return response;
    }
}