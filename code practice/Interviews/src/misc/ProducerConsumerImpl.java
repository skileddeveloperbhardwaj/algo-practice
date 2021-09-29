package misc;

import java.util.LinkedList;

public class ProducerConsumerImpl {
    static LinkedList<Integer> list = new LinkedList<>();
    Object lock = new Object();
    int val = 0;

    public void produce() {
        while (true) {
            synchronized (lock) {
                while (list.size() >= 10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("Produced value::" + val++);
                list.add(val);
                lock.notify();
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (lock) {
                while (list.size() < 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println("Consumed value is::" + list.removeFirst());
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerImpl pc = new ProducerConsumerImpl();

        Thread t1 = new Thread(() -> {
            pc.produce();
        });

        Thread t2 = new Thread(() -> {
            pc.consume();
        });

        t1.start();
        t2.start();
    }
}
