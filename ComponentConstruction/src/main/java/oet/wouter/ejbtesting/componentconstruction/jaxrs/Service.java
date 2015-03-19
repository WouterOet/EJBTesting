package oet.wouter.ejbtesting.componentconstruction.jaxrs;

import oet.wouter.ejbtesting.componentconstruction.Target;
import oet.wouter.ejbtesting.componentconstruction.UsageTarget;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class Service {

    @EJB
    Target target;

    @EJB
    UsageTarget usageTarget;

    @GET
    @Path("/usage")
    public String invokeUsage() {
        try {
            usageTarget.invoke();
        } catch (Exception e) {
            return "Received exception: " + e.getClass().getName() + " with cause " + e.getCause().getClass().getName();
        }

        return "success";
    }

    @GET
    @Path("/construct")
    public String invoke() {
        target.invoke();
        return "success";
    }
}
