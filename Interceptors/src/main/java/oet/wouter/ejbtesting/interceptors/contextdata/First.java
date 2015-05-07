package oet.wouter.ejbtesting.interceptors.contextdata;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class First {

    @AroundInvoke
    public Object wrap(InvocationContext context) throws Exception {
        context.getContextData().put("my-key", "my-value");
        return context.proceed();
    }

}
