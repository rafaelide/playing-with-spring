package com.rafaelide.spring.bean.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Computer implements InitializingBean, DisposableBean, BeanNameAware {

    private CPU cpu;


    private String serialNumber;

    @Value("${computer.model}")
    private String model;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    @Value("${computer.serial-number}")
    public void setSerialNumber(String serialNumber) {
        System.out.println("Computer - injecting property through setter method");
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
