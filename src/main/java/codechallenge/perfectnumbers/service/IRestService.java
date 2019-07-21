package codechallenge.perfectnumbers.service;


import javax.ws.rs.core.Response;

/**
 * @author kolin
 *
 */
public interface IRestService<T> {

    Response execute(T params);

}