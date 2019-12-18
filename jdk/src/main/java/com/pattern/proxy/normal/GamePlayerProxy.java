package com.pattern.proxy.normal;

import com.pattern.proxy.normal.impl.GamePlayer;
import com.pattern.proxy.normal.interfances.IGamePlayer;
import com.pattern.proxy.normal.interfances.IPorxy;

public class GamePlayerProxy implements IGamePlayer, IPorxy {

    private IGamePlayer gamePlayer = null;

    public GamePlayerProxy(String name){
        try {
            gamePlayer = new GamePlayer(this,name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
        this.count();
    }

    //强制代理部分
    public GamePlayerProxy(IGamePlayer gamePlayer){
        this.gamePlayer = gamePlayer;
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }


    @Override
    public void count() {
        System.out.println("升级一次收5元！");
    }
}
