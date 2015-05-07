package oet.wouter.ejbtesting.asynchronous.slow;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
public class SlowServiceOne {

    @Asynchronous
    public Future<Long> invoke() throws Exception {
        Thread.sleep(5000); // This is illegal but who cares
        return new AsyncResult<>(1234L);
    }

}
