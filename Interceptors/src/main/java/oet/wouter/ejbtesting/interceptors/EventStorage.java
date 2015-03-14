package oet.wouter.ejbtesting.interceptors;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
@Startup
@javax.interceptor.ExcludeDefaultInterceptors
public class EventStorage {

    private final List<String> events = new ArrayList<>();

    public void addEvent(String event) {
        events.add(event);
    }

    public void clear() {
        events.clear();
    }

    public List<String> getEvents() {
        return events;
    }
}
