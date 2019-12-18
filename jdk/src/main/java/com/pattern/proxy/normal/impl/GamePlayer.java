package com.pattern.proxy.normal.impl;

import com.pattern.proxy.normal.GamePlayerProxy;
import com.pattern.proxy.normal.interfances.IGamePlayer;

public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(IGamePlayer gamePlayer, String name) throws Exception{
        if (null == gamePlayer){
            throw new Exception("不能创建真是角色");
        }else {
            this.name = name;
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(this.name + " 在打怪！");
        } else {
            System.out.println("请使用制定的代理访问！");
        }
    }

    @Override
    public void login(String user, String password) {
        if (!this.isProxy()){
            System.out.println("请使用制定的代理访问！");
        }else {
            System.out.println("用户名：" + user  + " 名字：" + this.name + "  密码： " + password);
        }
    }

    @Override
    public void upgrade() {
        if (!this.isProxy()){
            System.out.println("请使用制定的代理访问！");
        }else {
            System.out.println(this.name + " 又升了一级");
        }
    }


    //强制代理部分
    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private IGamePlayer proxy = null;

    public GamePlayer(String name) {
        this.name = name;
    }

    private boolean isProxy(){
        if (null != this.proxy){
            return true;
        }else {
            return false;
        }
    }

}
