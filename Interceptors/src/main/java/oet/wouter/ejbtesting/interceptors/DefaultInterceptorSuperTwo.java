package oet.wouter.ejbtesting.interceptors;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class DefaultInterceptorSuperTwo {

    @EJB
    EventStorage eventStorage;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        eventStorage.addEvent(DefaultInterceptorSuperTwo.class.getName() + " instance invoked");
        return context.proceed();
    }
}
