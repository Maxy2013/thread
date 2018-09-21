package com.thread;

/**
 * 作战的军队
 * @author lz
 * 2018/9/21 17:21
 */
public class ArmyRunnable implements Runnable{

    //使用 volatile 保证了线程可以读取其他线程写入的值
    //保证共享变量的可见性，资料 - 详见 JMM java的内存模型
    volatile boolean keepRunning = true;//程序启动就开始执行

    @Override
    public void run() {

        while (keepRunning){
            //发动5次攻击
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + "发动了 [" +i+ "]次攻击");
                //此时占用资源的线程让出CPU资源，让其他线程开始发动攻击
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + "结束了战斗！");
    }
}
