package com.zl.awesome.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: netposa
 * @Date: 2020/12/6 16:00
 * @Description:
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket =null;
        serverSocket = new ServerSocket(8080);
        //建立socket连接
        Socket accept = serverSocket.accept();
        //get User
        ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
        User user = (User) objectInputStream.readObject();
        System.out.println(user);
    }
}
