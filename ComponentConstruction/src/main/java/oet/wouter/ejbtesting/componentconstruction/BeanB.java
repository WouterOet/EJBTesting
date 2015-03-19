package oet.wouter.ejbtesting.componentconstruction;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

@Singleton
public class BeanB {

    @PostConstruct
    private void init() {
        System.out.println("BeanB created");
    }
}
