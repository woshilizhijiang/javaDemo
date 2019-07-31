package com.netty.officialWebsite.servers.Server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;


public class ServerHandlerDEMO extends ChannelInboundHandlerAdapter {

    /**
     * writing a discard server
     * 该部分为业务逻辑
     */
    public static void discardServer(Object msg){
        ((ByteBuf)msg).release();
    }

    /**
     * looking into the Received Data
     */
    public static void receiveDataServer(Object msg){
        ByteBuf in = (ByteBuf) msg;
            try {
            while (in.isReadable()) { // (1)
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }

    /**
     * Writing an Echo Server
     * telnet host port
     * 输入你的内容会自动响应
     * @param msg
     */
    public static void echoServer(ChannelHandlerContext ctx, Object msg){
        ctx.write(msg);
        ctx.flush();
    }

    /**
     * Writing a Time Server
     * @param ctx
     * @param msg
     */
    public static void timeServer(ChannelHandlerContext ctx, Object msg){
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        discardServer(msg);
//        receiveDataServer(msg);
//        echoServer(ctx,msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //close the connection when an execption is raised
        cause.printStackTrace();
        ctx.close();
    }
}
