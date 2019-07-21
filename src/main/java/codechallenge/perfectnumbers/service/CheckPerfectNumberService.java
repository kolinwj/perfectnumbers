package codechallenge.perfectnumbers.service;


import codechallenge.perfectnumbers.core.ComputePerfectNumbers;
import codechallenge.perfectnumbers.core.PerfectNumberStatus;
import javax.ws.rs.core.Response;

/**
 * @author kolin
 *
 */
public class CheckPerfectNumberService implements IRestService<Long> {

    @Override
    public Response execute(Long number) {
        boolean status = ComputePerfectNumbers.isPerfectNumber(number);
        PerfectNumberStatus numberStatus = new PerfectNumberStatus(number, status);

        return Response.status(Response.Status.OK).entity(numberStatus).build();
    }
}