package com.java8.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferMethod {

    public static void main(String[] args){
        BufferMethod bm = new BufferMethod();
//        bm.byteBuffer_01();
//        bm.charBuffer_01();
//        bm.byteBuffer_02();
//        bm.compareDirectAndJVM();
//        bm.btyeExp();

//        byte[] bytes = new byte[]{1,2,3,'a','b','c','a','b','c','a','b','c'};
        //Exception in thread "main" java.nio.BufferOverflowException
        // 缓存区溢出
        ByteBuffer buffer = ByteBuffer.allocate(22);
        String value = "Netty权威指南";

        System.out.println("Bytes: " + value.getBytes().length);

        buffer.put(value.getBytes());
        buffer.flip();
        byte[] vArray = new byte[buffer.remaining()];
        buffer.get(vArray);
        String decodeValue = new String(vArray);
        System.out.println(decodeValue);

    }

    private void btyeExp(){

        byte[] byteArray = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12};

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        int getArrayIndex = 0;

        while(getArrayIndex < byteArray.length){
            int readLength = Math.min(byteBuffer.remaining(), byteArray.length - getArrayIndex);

            byteBuffer.put(byteArray,getArrayIndex, readLength);
            byteBuffer.flip();

            byte[] getArray = byteBuffer.array();
            for(int i = 0; i < byteBuffer.limit(); i++){
                System.out.println(getArray[i] + " ");
            }
            getArrayIndex = getArrayIndex + readLength;


            System.out.println();
            byteBuffer.clear();

        }
    }


    private void compareDirectAndJVM(){
        long start = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocateDirect(190000000);
        for (int i = 0; i < 190000000;i++){
            buffer.put((byte)i);
        }

        long end = System.currentTimeMillis();
        ByteBuffer buffer2 = ByteBuffer.allocate(190000000);
        for (int i = 0; i < 190000000;i++){
            buffer2.put((byte)i);
        }
        long end2 = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(end2 - end);
    }

    private void byteBuffer_02(){
        byte[] byteArrays = new byte[]{1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
//        byteBuffer.put((byte)1);
        byteBuffer.put(new byte[]{3,4,5});
        System.out.println(byteBuffer.isDirect());
        System.out.println(byteBuffer.hasArray());

    }
    private void charBuffer_01(){
        char[] charArray = new char[]{'a','b','c','d'};
        CharBuffer buffer =  CharBuffer.wrap(charArray);
//        buffer.asReadOnlyBuffer(); //设置无效

        System.out.println(
                "capacity:" + buffer.capacity() + "\r\n" +
                "limit:" + buffer.limit() + "\r\n" +
                        "position:" + buffer.position() + "\r\n" +
                        "mark:" + buffer.mark() + "\r\n" +
                        "remaining : " + buffer.remaining() + "\r\n" +
                        "isDirect : " + buffer.isDirect() + "\r\n" +
                        "isReadOnly : " + buffer.isReadOnly()
        );
//        buffer.limit(3);
//        System.out.println(
//                "capacity:" + buffer.capacity() +
//                "limit:" + buffer.limit()
//        );
//        buffer.put(0,'h');
//        buffer.put(1,'h');
//        buffer.put(2,'h');
//
//        buffer.put(3,'h'); //linit限制索引到3的元素
//        buffer.put(4,'h');
//        buffer.put(5,'h');
    }

    private void byteBuffer_01(){
        byte[] byteArrays = new byte[]{1,2,3,4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrays);
        System.out.println(
                "mark:" + byteBuffer.mark() +
                " position:" + byteBuffer.position() +
                " limit:" + byteBuffer.limit() +
                " capacity:" + byteBuffer.capacity() +
                " name:" + byteBuffer.getClass().getName()
        );
        for (byte bt:byteArrays) {
            System.out.println(bt);
        }
    }
}
