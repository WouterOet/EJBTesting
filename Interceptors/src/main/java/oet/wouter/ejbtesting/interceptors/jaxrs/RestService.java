package oet.wouter.ejbtesting.interceptors.jaxrs;

import oet.wouter.ejbtesting.interceptors.contextdata.DataTarget;
import oet.wouter.ejbtesting.interceptors.EventStorage;
import oet.wouter.ejbtesting.interceptors.order.Target;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class RestService {

    @EJB
    Target target;

    @EJB
    DataTarget dataTarget;

    @EJB
    EventStorage eventStorage;

    @GET
    @Path("/invoke/data")
    public String invokeContextData() {
        dataTarget.invoke();
        return getEvents();
    }

    @GET
    @Path("/invoke")
    public String invokeMethod() {
        target.method();
        return getEvents();
    }

    private String getEvents() {
        List<String> events = eventStorage.getEvents();
        String result = String.join("\n", events);
        eventStorage.clear();
        return result;
    }

}
