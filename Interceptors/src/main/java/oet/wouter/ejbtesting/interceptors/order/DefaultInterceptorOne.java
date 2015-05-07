package oet.wouter.ejbtesting.interceptors.order;

import oet.wouter.ejbtesting.interceptors.EventStorage;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class DefaultInterceptorOne extends DefaultInterceptorSuperOne {

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
