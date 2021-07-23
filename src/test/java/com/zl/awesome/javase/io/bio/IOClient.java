package com.zl.awesome.javase.io.bio;

import javax.xml.crypto.Data;
import java.net.Socket;
import java.util.Date;

/**
 * @author: netposa
 * @Date: 2021/4/19 15:53
 * @Description:   BIO客户端
 */
public class IOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() ->{
            try {
                Socket socket = new Socket("127.0.0.1",3333);
                while (true){
                    try {
                        socket.getOutputStream().write((new Date() +": hello world").getBytes());
                    }catch (Exception e){
                    }
                }
            }catch (Exception ignored) {
            }
        }).start();
    }
}
