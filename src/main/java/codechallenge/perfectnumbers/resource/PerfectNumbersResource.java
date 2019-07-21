package codechallenge.perfectnumbers.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author kolin
 *
 */

@Path("v1/perfectnumbers")
@Produces(MediaType.APPLICATION_JSON)
public interface PerfectNumbersResource {

    @GET
    @Path("{number}")
    Response checkIsPerfectNumber(@PathParam("number")Long number);

    @GET
    Response getPerfectNumbers(@QueryParam("startNumber")Long lowerNumber, @QueryParam("endNumber")Long upperNumber);

}