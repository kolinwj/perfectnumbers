package codechallenge.perfectnumbers.resource;

import javax.ws.rs.core.Response;
import codechallenge.perfectnumbers.service.Parameters;
import codechallenge.perfectnumbers.service.IRestService;
import codechallenge.perfectnumbers.service.RestServiceFactory;


/**
 * @author kolin
 *
 */
public class PerfectNumbersImpl implements PerfectNumbersResource {

    private IRestService service;

    @Override
    public Response checkIsPerfectNumber(Long number) {
        service = RestServiceFactory.getRestService(RestServiceFactory.ServiceType.SERVICE_CHECK_IS_A_PERFECT_NUMBER);

        return service.execute(number);
    }

    @Override
    public Response getPerfectNumbers(Long startNumber, Long endNumber) {
        service = RestServiceFactory.getRestService(RestServiceFactory.ServiceType.SERVICE_GET_PERFECT_NUMBERS);
        Parameters params = new Parameters(startNumber, endNumber);

        return service.execute(params);
    }

}