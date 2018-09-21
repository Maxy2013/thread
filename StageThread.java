package com.thread;

/**
 * @author lz
 * 2018/9/21 17:30
 */
public class StageThread extends Thread{

    @Override
    public synchronized void run() {
        System.out.println("舞台的帷幕徐徐拉开，隋唐演义即将上演，请大家保持安静。");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋朝末年。。。。");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArmyRunnable armyTaskOfSui = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolte = new ArmyRunnable();

        //使用Runnable创建线程
        Thread armyOfSui = new Thread(armyTaskOfSui, "随军");
        Thread armyOfRevolte = new Thread(armyTaskOfRevolte, "农民起义军");

        armyOfSui.start();
        armyOfRevolte.start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //关键人物线程
        Thread thread = new KeyPersonThread();
        thread.setName("程咬金");
        thread.start();


        armyTaskOfSui.keepRunning = false;
        armyTaskOfRevolte.keepRunning = false;
//不是正确停止线程的方法
//        armyOfSui.stop();
//        armyOfRevolte.stop();
        try {
           thread.join();//使用了join方法，表示所有线程需要等待执行了join方法的线程执行完毕之后才能执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，人民安居乐业实现了他的伟大抱负");
        System.out.println("谢谢观看隋唐演义，再见。");


    }

    public static void main(String[] args) {
        new StageThread().start();
    }
}
