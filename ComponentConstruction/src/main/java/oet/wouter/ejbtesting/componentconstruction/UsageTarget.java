package oet.wouter.ejbtesting.componentconstruction;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.security.Principal;

@Stateless
public class UsageTarget {

    @Resource
    SessionContext context;

    /**
     * This method demonstrates the illegal usage of the SessionContext in the @PostConstruct.
     */
    @PostConstruct
    private void init() {
        context.getCallerPrincipal();
    }

    public void invoke() {
        System.out.println("Invoked");
    }

}
