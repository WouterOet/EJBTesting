package oet.wouter.ejbtesting.interceptors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class DefaultInterceptorTwo extends DefaultInterceptorSuperTwo {

    @EJB
    EventStorage eventStorage;

    @PostConstruct
    private void init() {
        eventStorage.addEvent(getClass().getName() + " instance created");
    }

    @AroundInvoke
    public Object intercept2(InvocationContext context) throws Exception {
        eventStorage.addEvent(getClass().getName() + " instance invoked");
        return context.proceed();
    }
}
