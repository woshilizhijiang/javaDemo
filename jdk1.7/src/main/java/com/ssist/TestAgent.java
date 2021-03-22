package com.ssist;

import java.lang.instrument.Instrumentation;

public class TestAgent {
    public static void premain(String[] args, Instrumentation inst) {
        System.out.println("Hi, I am agent.");
        inst.addTransformer(new TestTransformer());
    }

}
