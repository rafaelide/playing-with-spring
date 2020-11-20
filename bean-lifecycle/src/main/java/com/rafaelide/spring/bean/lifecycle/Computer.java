package com.rafaelide.spring.bean.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Computer implements InitializingBean, DisposableBean, BeanNameAware {

    private CPU cpu;

    public Computer(CPU cpu) {
        System.out.println("Computer - executing constructor");
        this.cpu = cpu;
    }

    @PostConstruct
    public void init() {
        System.out.println("Computer - executing @PostConstruct annotated method");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Computer - executing @PreDestroy annotated method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Computer - executing implementation of DisposableBean interface, method destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Computer - executing implementation of InitializingBean interface, method afterPropertiesSet()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Computer - executing implementation of BeanNameAware interface, method setBeanName()");
    }
}
