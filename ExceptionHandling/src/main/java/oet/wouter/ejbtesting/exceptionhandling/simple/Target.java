package oet.wouter.ejbtesting.exceptionhandling.simple;

import oet.wouter.ejbtesting.exceptionhandling.EventStorage;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Target {

    @EJB
    EventStorage eventStorage;

    public void throwRuntimeException() {
        eventStorage.addEvent("Target throws RuntimeException");
        throw new RuntimeException();
    }

    public void throwApplicationException() {
        eventStorage.addEvent("Target throws ApplicationException");
        throw new MyApplicationException();
    }

}
