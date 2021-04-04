package com.lc.dr.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImplA implements TestService {
    @Override
    public String type() {
        return "A";
    }

    @Override
    public boolean test(String A) {
        System.out.println(A);
        return true;
    }
}
