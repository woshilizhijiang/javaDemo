package com.netty.officialWebsite.servers.Server;

import com.netty.officialWebsite.servers.Server.handler.ServerHandlerDEMO;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServerDEMO {

    private int port;

    public NettyServerDEMO(int port){
        this.port = port;
    }

    public void run(){
        normal();
    }



    private void normal() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ServerHandlerDEMO());
//                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f =  b.bind(port).sync();
            f.channel().closeFuture().sync();

        }catch (Exception e){
            System.out.println("错误了。" + e);
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args){
        int port = 8082;
        if (args.length > 0){
            port = Integer.valueOf(args[0]);
        }
        new NettyServerDEMO(port).run();
    }

}
