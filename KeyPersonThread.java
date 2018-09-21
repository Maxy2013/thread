package com.thread;

/**
 * @author lz
 * 2018/9/21 18:00
 */
public class KeyPersonThread extends Thread{
    @Override
    public void run() {
        System.out.println("关键人物加入战斗");

        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "出场作战了，他奋力拼杀[" +i+ "]");
        }
        System.out.println("关键人物" + Thread.currentThread().getName() + "的战斗结束了，战争取得了最终胜利");
    }
}
