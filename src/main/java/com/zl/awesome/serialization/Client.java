package com.zl.awesome.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: netposa
 * @Date: 2020/12/6 16:04
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        socket=new Socket("localhost",8080);

        User user = new User();
        user.setAge(18);
        user.setName("zl");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);
        socket.close();
    }
}
