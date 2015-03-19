package oet.wouter.ejbtesting.exceptionhandling.simple;

import oet.wouter.ejbtesting.exceptionhandling.EventStorage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * This demonstrates the situation in which an (application) exception is thrown.
 */
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

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void throwRuntimeExceptionWithoutTransaction() {
        eventStorage.addEvent("Target throws RuntimeException without a transaction");
        throw new RuntimeException();
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void throwApplicationExceptionWithoutTransaction() {
        eventStorage.addEvent("Target throws ApplicationException without a transaction");
        throw new MyApplicationException();
    }

}
