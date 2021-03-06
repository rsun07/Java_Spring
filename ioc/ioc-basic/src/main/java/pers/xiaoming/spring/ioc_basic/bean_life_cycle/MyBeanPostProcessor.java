package pers.xiaoming.spring.ioc_basic.bean_life_cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
          if (s.equals("myBean")) {
              System.out.println("My Bean post process before init method");
          }
          return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof LifecycleBean) {
            System.out.println("My Bean post process after init method");
            ((LifecycleBean) o).setName("Post Process Reset Name");
        }
        return o;
    }
}
