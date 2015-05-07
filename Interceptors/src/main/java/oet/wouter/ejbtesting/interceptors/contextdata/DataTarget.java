package oet.wouter.ejbtesting.interceptors.contextdata;

import oet.wouter.ejbtesting.interceptors.EventStorage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(First.class)
public class DataTarget {

    @EJB
    EventStorage eventStorage;

    @Interceptors(Second.class)
    public void invoke() {
        eventStorage.addEvent("DataTarget called");
    }

}
