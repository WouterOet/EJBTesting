package oet.wouter.ejbtesting.asynchronous.jaxrs;

import oet.wouter.ejbtesting.asynchronous.slow.SlowServiceOne;
import oet.wouter.ejbtesting.asynchronous.slow.SlowServiceTwo;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.Future;

@Path("/")
public class Service {

    @EJB
    SlowServiceOne slowServiceOne;

    @EJB
    SlowServiceTwo serviceB;

    @GET
    @Path("/invoke")
    public String invoke() throws Exception {
        long start = System.currentTimeMillis();
        Future<Long> a = slowServiceOne.invoke();
        Future<Long> b = serviceB.invoke();
        String result = "" + a.get() + " " + b.get();
        long time = System.currentTimeMillis() - start;

        return "Calculated '" + result + "' in " + time + " milliseconds.";
    }
}
