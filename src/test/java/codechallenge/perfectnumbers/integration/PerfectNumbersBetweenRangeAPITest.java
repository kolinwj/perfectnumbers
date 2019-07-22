package codechallenge.perfectnumbers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import codechallenge.perfectnumbers.exception.ErrorMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import codechallenge.perfectnumbers.core.PerfectNumberList;


/**
 * @author kolin
 *
 * Test REST API, perfect numbers for given number range. Test Cases are,
 * 1. If there are perfect numbers then return perfect numbers
 * 2. Not a valid request. Should return an error response 
 */

public class PerfectNumbersBetweenRangeAPITest extends RestAPIIntegrationTest {

    @Test
    public void testNumbersBetweenRange() throws IOException {
    	
        HttpGet get = new HttpGet(URL + "?startNumber=1&endNumber=100");
        HttpResponse response = client.execute(get);

        assertEquals(200, response.getStatusLine().getStatusCode());
        ObjectMapper mapper = new ObjectMapper();
        PerfectNumberList list = mapper.readValue(response.getEntity().getContent(), PerfectNumberList.class);
        assertEquals(Long.valueOf(6), list.getPerfectNumbersList().get(0));

    }

    @Test
    public void testInvalidParams() throws IOException {
    	
        HttpGet get = new HttpGet(URL + "?startNumber=1&endNumber=dd10");
        HttpResponse response = client.execute(get);

        ObjectMapper mapper = new ObjectMapper();
        ErrorMessage message = mapper.readValue(response.getEntity().getContent(), ErrorMessage.class);
        assertEquals(400, response.getStatusLine().getStatusCode());
        assertTrue(message.getErrorMessage().contains(conf.getProperty("api.error.code.2")));
        
    }
}