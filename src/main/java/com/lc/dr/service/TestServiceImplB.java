package com.lc.dr.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImplB implements TestService {


    @Override
    public String type() {
        return "B";
    }

    @Override
    public boolean test(String B) {
        System.out.println("testB");
        return true;
    }
}
