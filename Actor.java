package com.thread;

/**
 * @author lz
 * 2018/9/21 17:04
 */
public class Actor extends Thread{

    @Override
    public void run() {
        System.out.println(getName() + "开始登台演出");

        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(getName() + "演出次数是： " + ++count);


            //每演出10场
            if(count%10 == 0){
                //中间稍事停顿
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //演出了100场该休息了
            if(count >= 100){
                keepRunning = false;
            }
        }


        System.out.println(getName() + "退出了舞台");
    }

    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress(), "Ms. Runnable");
        actress.start();
    }
}

class Actress implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始登台演出");

        int count = 0;
        boolean keepRunning = true;
        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + "演出次数是： " + ++count);


            //每演出10场
            if(count%10 == 0){
                //中间稍事停顿
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //演出了100场该休息了
            if(count >= 100){
                keepRunning = false;
            }
        }


        System.out.println(Thread.currentThread().getName() + "退出了舞台");
    }
}
