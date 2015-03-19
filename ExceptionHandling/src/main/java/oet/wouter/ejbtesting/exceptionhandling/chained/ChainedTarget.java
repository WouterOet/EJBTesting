package oet.wouter.ejbtesting.exceptionhandling.chained;

import oet.wouter.ejbtesting.exceptionhandling.EventStorage;
import oet.wouter.ejbtesting.exceptionhandling.simple.Target;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * This demonstrates what happens when an EJB calls another EJB which in turn throws an exception.
 */
@Stateless
public class ChainedTarget {

    @EJB
    Target target;

    @EJB
    EventStorage eventStorage;

    public void invokeRuntime() {
        invoke(target::throwRuntimeException);
    }

    public void invokeApplication() {
        invoke(target::throwApplicationException);
    }

    public void invoke(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            addEvent(e);
            throw e;
        }
    }

    private void addEvent(Exception e) {
        String className = getClass().getName();
        String exceptionClassName = e.getClass().getName();
        eventStorage.addEvent(className + " received " + exceptionClassName +
                (e.getCause() == null ?
                        " with no cause." :
                        " with cause " + e.getCause().getClass().getName()));
    }


}
