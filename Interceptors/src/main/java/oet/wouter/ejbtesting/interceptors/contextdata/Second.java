package oet.wouter.ejbtesting.interceptors.contextdata;

import oet.wouter.ejbtesting.interceptors.EventStorage;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Second {

    @EJB
    EventStorage eventStorage;

    @AroundInvoke
    public Object wrap(InvocationContext context) throws Exception {
        eventStorage.addEvent((String) context.getContextData().get("my-key"));
        return context.proceed();
    }
}
