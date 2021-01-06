package com.zl.awesome.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author: netposa
 * @Date: 2020/12/28 18:32
 * @Description:
 */
public class Producer implements Runnable{

    BlockingQueue<Mantou> queue;

    public Producer(BlockingQueue<Mantou> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Mantou mantou = new Mantou(""+i);
            try {
                Thread.sleep(100);
                queue.put(mantou);
                System.out.println("生产馒头： " + mantou.getMantou());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //添加退出消息
        Mantou exit = new Mantou("exit");
        try {
            queue.put(exit);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
