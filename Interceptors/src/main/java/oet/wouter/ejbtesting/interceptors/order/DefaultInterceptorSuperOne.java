package oet.wouter.ejbtesting.interceptors.order;

import oet.wouter.ejbtesting.interceptors.EventStorage;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class DefaultInterceptorSuperOne {

    @EJB
    EventStorage eventStorage;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        eventStorage.addEvent(DefaultInterceptorSuperOne.class.getName() + " instance invoked");
        return context.proceed();
    }
}
