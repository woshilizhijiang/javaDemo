//package com.netty.definitiveGuide.intermediate.encode.cilent;
//
//import com.example.tutorial.SubscribeReqProto;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
//
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        for (int i=0; i < 10;i++){
//            ctx.write(subReq(i));
//        }
//    }
//    private SubscribeReqProto.SubscribeReq subReq(int i){
//        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
//        builder.setSubReqID(i);
//        builder.setUserName("Liyuanxin");
//        builder.setProductName("Netty Book For Protobuf");
//        List<String> address = new ArrayList<String>();
//        address.add("NanJing YuHuaTai");
//        address.add("BeiJing XiDan");
//        address.add("ShenZhen Luohu");
//        builder.addAllAddress(address);
//        return builder.build();
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("Receive server response : [" +  msg + "]");
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
//}
