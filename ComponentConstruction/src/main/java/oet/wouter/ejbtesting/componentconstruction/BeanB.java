package oet.wouter.ejbtesting.componentconstruction;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class BeanB {

    @PostConstruct
    private void init() {
        System.out.println("BeanB created");
    }
}
