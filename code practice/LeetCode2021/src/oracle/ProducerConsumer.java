package oracle;

import java.util.ArrayList;

public class ProducerConsumer {
    private ArrayList<Integer> arr;
    static Object lock = new Object();
    private static final int MAX_SIZE = 2;
    private int value = 0;
    private int index = 0;

    public ProducerConsumer() {
        arr = new ArrayList<>();
    }

    public void produce() {
        while (true) {
            synchronized (lock) {
                while (arr.size() == MAX_SIZE) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {

                    }
                }
                arr.add(value++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
                System.out.println("Producer produced:" + value);
                lock.notify();
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (lock) {
                while (arr.size() == 0) {
                    try {
                        index = -0;
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                if(index >=arr.size()) {
                    index = arr.size()-1;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
                System.out.println("Consumer consumed::" + arr.remove(index++));
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread prod = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.produce();
            }
        });
        prod.start();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                pc.consume();
            }
        });
        consumer.start();
    }
}
