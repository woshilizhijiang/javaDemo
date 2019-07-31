package com.pattern.builder.demo01;

public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println ("宝马车跑起来是这个样子的。。。");
    }

    @Override
    protected void stop() {
        System.out.println ( "宝马车应该这样停车....");
    }

    @Override
    protected void alarm() {
        System.out.println ("宝马车的喇叭卢音是这个样子的 ...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马车的引擎是这个卢音的...");
    }
}
