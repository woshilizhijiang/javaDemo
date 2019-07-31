package com.java8.nio.selector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class MySelectorClient {

    private ByteBuffer sendBuffer = ByteBuffer.allocateDirect(1024);
    private ByteBuffer receiveBuffer = ByteBuffer.allocateDirect(1024);
    private Selector selector;

    public MySelectorClient() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(),8088));
        socketChannel.configureBlocking(false);
        System.out.println("与服务器的连接建立成功");

        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    public static void main(String[] args) throws IOException{
        MySelectorClient client=new MySelectorClient();
        Thread receiver=new Thread(client::receiveFromuser);

        receiver.start();
        client.talk();

    }

    private void talk() throws IOException{
        while (selector.select() > 0 ){

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key = it.next();
                it.remove();

                if (key.isReadable()) {
                    receive(key);
                }
                // 实际上只要注册了关心写操作，这个操作就一直被激活
                if (key.isWritable()) {
                    send(key);
                }
            }

        }
    }
    private void send(SelectionKey key) throws  IOException{
        SocketChannel socketChannel=(SocketChannel)key.channel();
        synchronized(sendBuffer){
            sendBuffer.flip(); //设置写
            while(sendBuffer.hasRemaining()){
                socketChannel.write(sendBuffer);
            }
            sendBuffer.compact();
        }
    }

    private void receive(SelectionKey key) throws IOException{
        SocketChannel socketChannel = (SocketChannel)key.channel();
        socketChannel.read(receiveBuffer);
        receiveBuffer.flip();
        String receiveData = Charset.forName("UTF-8").decode(receiveBuffer).toString();
        System.out.println("receive server message:"+receiveData);
        receiveBuffer.clear();
    }

    private void receiveFromuser(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String msg;
            while (null != (msg = bufferedReader.readLine())){
                synchronized (sendBuffer){
                    sendBuffer.put((msg + "\r\n").getBytes());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
