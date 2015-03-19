package oet.wouter.ejbtesting.interceptors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

/**
 * This demonstrates the invocation order of interceptors.
 */
@Stateless
@Interceptors({ClassLevelInterceptorOne.class, ClassLevelInterceptorTwo.class})
public class Target extends TargetSuperInterceptor {

    @EJB
    EventStorage eventStorage;

    @Interceptors(MethodLevelInterceptor.class)
    public void method() {
        eventStorage.addEvent("Method invoked!");
    }

    @AroundInvoke
    public Object intercept2(InvocationContext context) throws Exception {
        eventStorage.addEvent("Inner class interceptor invoked");
        return context.proceed();
    }
}
