package codechallenge.perfectnumbers.service;

/**
 * @author kolin
 *
 */
public class RestServiceFactory {

    public enum ServiceType {
    	SERVICE_CHECK_IS_A_PERFECT_NUMBER,
        SERVICE_GET_PERFECT_NUMBERS
    }
	
    public static IRestService<?> getRestService(final ServiceType service) {
        switch (service) {
            case SERVICE_CHECK_IS_A_PERFECT_NUMBER:
                return new CheckPerfectNumberService();
            case SERVICE_GET_PERFECT_NUMBERS:
                return new GetPerfectNumbersService();
            default:
                return null;
        }
    }



}