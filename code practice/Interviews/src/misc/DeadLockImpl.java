package misc;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class DeadLockImpl {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void fun1() {
        synchronized (lock1) {
            System.out.println("lock1--> fun1");
            try {
                Thread.sleep(100);
                synchronized (lock2){
                    System.out.println("lock2--> fun1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fun2() {
        synchronized (lock2) {
            System.out.println("lock2--> fun2");
            try {
                Thread.sleep(100);
                synchronized (lock1) {
                    System.out.println("lock1--> fun2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                fun1();
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                fun2();
            }
        });
        t1.start();
        t2.start();

    }
}
