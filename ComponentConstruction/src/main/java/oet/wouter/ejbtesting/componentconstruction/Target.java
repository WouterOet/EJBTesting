package oet.wouter.ejbtesting.componentconstruction;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * This class demonstrates the invocation order of lifecycle callbacks.
 */
@Stateless
public class Target {

    public void invoke() {
        System.out.println("Instance method invoked");
    }

    @PostConstruct
    public void init() {
        System.out.println("Instance created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Instance destroyed");
    }

}
