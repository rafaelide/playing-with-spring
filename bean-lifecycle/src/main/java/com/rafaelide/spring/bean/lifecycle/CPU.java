package com.rafaelide.spring.bean.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class CPU {

    public CPU() {
        System.out.println("CPU - constructor");
    }

}
