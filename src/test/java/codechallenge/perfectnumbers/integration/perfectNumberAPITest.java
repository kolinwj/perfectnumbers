package codechallenge.perfectnumbers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import codechallenge.perfectnumbers.core.PerfectNumberStatus;
import codechallenge.perfectnumbers.exception.ErrorMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author kolin
 *
 * Test REST API, is perfect number? Test Cases are,
 * 1. Is a perfect number (Expect success)
 * 2. Not a perfect number (Expect failed)
 * 3. Is not a valid number (Expect failed). Number validity
 */

public class perfectNumberAPITest extends RestAPIIntegrationTest {

    @Test
    public void testIsPerfectNumbers() throws IOException {
    	
        HttpGet get = new HttpGet(URL + 28);
        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        PerfectNumberStatus status = mapper.readValue(response.getEntity().getContent(), PerfectNumberStatus.class);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertTrue(status.isValid());

    }

    @Test
    public void testIsNotPerfectNumber() throws IOException {
        
    	HttpGet get = new HttpGet(URL + 29);
        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        PerfectNumberStatus status = mapper.readValue(response.getEntity().getContent(), PerfectNumberStatus.class);
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertFalse(status.isValid());
    }

    @Test
    public void testIsInvalidNumber() throws IOException {
        
    	HttpGet get = new HttpGet(URL + "12d");
        HttpResponse response = client.execute(get);
        ObjectMapper mapper = new ObjectMapper();
        ErrorMessage message = mapper.readValue(response.getEntity().getContent(), ErrorMessage.class);
        assertEquals(400, response.getStatusLine().getStatusCode());
        assertEquals(400, message.getStatus());
    }

}