package com.pattern.proxy.normal.interfances;

public interface IGamePlayer {
    void killBoss();
    void login(String user, String password);
    void upgrade();

    //强制代理部分
    IGamePlayer getProxy();
}
