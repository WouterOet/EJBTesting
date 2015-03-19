package oet.wouter.ejbtesting.exceptionhandling.jaxrs;

import oet.wouter.ejbtesting.exceptionhandling.EventStorage;
import oet.wouter.ejbtesting.exceptionhandling.chained.ChainedTarget;
import oet.wouter.ejbtesting.exceptionhandling.simple.Target;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class Service {

    @EJB
    Target target;

    @EJB
    ChainedTarget chainedTarget;

    @EJB
    EventStorage eventStorage;

    @GET
    @Path("simple/runtime")
    public String invokeWithRuntimeException() {
        return invoke(target::throwRuntimeException);
    }

    @GET
    @Path("simple/application")
    public String invokeWithApplicationException() {
        return invoke(target::throwApplicationException);
    }

    @GET
    @Path("chained/runtime")
    public String invokeWithChainedRuntimeException() {
        return invoke(chainedTarget::invokeRuntime);
    }

    @GET
    @Path("chained/application")
    public String invokeWithChainedApplicationException() {
        return invoke(chainedTarget::invokeApplication);
    }

    @GET
    @Path("transaction/runtime")
    public String invokeWithRuntimeExceptionWithoutTransaction() {
        return invoke(target::throwRuntimeExceptionWithoutTransaction);
    }
    @GET
    @Path("transaction/application")
    public String invokeWithApplicationExceptionWithoutTransaction() {
        return invoke(target::throwApplicationExceptionWithoutTransaction);
    }

    private String invoke(Runnable r) {
        try {
            r.run();
        } catch (Exception e) {
            Throwable cause = e.getCause();
            eventStorage.addEvent("End-point received exception: " + e.getClass().getName() + (cause == null ? " with no cause" : " with cause " + cause.getClass().getName()));
        }
        String result = String.join("\n", eventStorage.getEvents());
        eventStorage.clear();

        return result;
    }


}
