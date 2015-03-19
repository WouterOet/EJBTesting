package oet.wouter.ejbtesting.componentconstruction;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * This class demonstrates the @DependsOn functionality provided by the EJB spec.
 */
@Singleton
@DependsOn("BeanB")
@Startup
public class BeanA {

    @PostConstruct
    private void init() {
        System.out.println("BeanA created");
    }
}
