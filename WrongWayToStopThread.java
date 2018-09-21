package com.thread;

public class WrongWayToStopThread extends Thread {

    public static void main(String[] args) {
        //创建一个线程
        WrongWayToStopThread thread = new WrongWayToStopThread();
        System.out.println("Start WrongWayToStopThread...");
        thread.start();
        //休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupt the thread...");
        thread.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Application stopped...");
    }

    @Override
    public void run() {
        //选择正确的停止线程的方法，设置标志符
        while (!this.isInterrupted()){
            System.out.println("The thread is running....");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000){
                //空循环，减少屏幕的输出带来的干扰
            }
        }
    }
}
