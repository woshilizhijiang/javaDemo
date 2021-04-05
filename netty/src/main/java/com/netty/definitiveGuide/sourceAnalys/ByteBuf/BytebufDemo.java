package com.netty.definitiveGuide.sourceAnalys.ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

public class BytebufDemo {


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("lizj11");
        for (int i = 0; i < 600 ;i++){
            stringBuilder.append("lizhj11");
        }
        String aa = stringBuilder.toString();


        int loop = 3000000;
        long startTime = System.currentTimeMillis();
        ByteBuf poolBuffer = null;
        for (int i = 0; i < loop ;i++){
            poolBuffer = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
            poolBuffer.writeBytes(aa.getBytes());
            poolBuffer.release();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-startTime);


        long startTime2 = System.currentTimeMillis();
        ByteBuf buffer = null;
        for (int i = 0; i < loop ;i++){
            buffer = Unpooled.directBuffer(1024);
            buffer.writeBytes(aa.getBytes());
            buffer.release();
        }

        long end2 = System.currentTimeMillis();
        System.out.println(end2-startTime2);

    }
}
