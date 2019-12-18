package com.pattern.proxy.normal;

import com.pattern.proxy.normal.impl.GamePlayer;
import com.pattern.proxy.normal.interfances.IGamePlayer;

public class Client {

    public static void main(String[] args) {

        //普通代理
        IGamePlayer proxy = new GamePlayerProxy("李元昕");
        proxy.login("liyuanxin","password");
        proxy.killBoss();
        proxy.upgrade();

        System.out.println("************************************************");

        //强制代理
        IGamePlayer player = new GamePlayer("lisi");
//        IGamePlayer proxy2 =  new GamePlayerProxy(player); //不成
        IGamePlayer proxy2 = player.getProxy();
        proxy2.login("lisi","password1");
        proxy2.killBoss();
        proxy2.upgrade();
    }
}
