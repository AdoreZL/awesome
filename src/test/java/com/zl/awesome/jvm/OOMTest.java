package com.zl.awesome.jvm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: netposa
 * @Date: 2021/1/14 09:51
 * @Description:
 */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while (true){
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024*1024)));
        }
    }
}

class Picture{
    private byte[] pixels;

    public Picture(int length){
        this.pixels = new byte[length];
    }
}
