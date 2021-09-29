package multithreading;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    LinkedList<Integer> stock = new LinkedList<>();
    int capacity;
    public ProducerConsumer(int c) {
        capacity = c;
    }

    public void produce() throws InterruptedException{
        int value =0;
        while (true) {
            synchronized (this) {
                while (stock.size() == capacity) wait();
                stock.add(value++);
                System.out.println("Producer produced::"+value);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException{
        while (true) {
            synchronized (this) {
                while(stock.size() == 0) wait();
                System.out.println("consumer consumed::"+stock.removeFirst());
                notify();
                Thread.sleep(1000 );
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ProducerConsumer pc = new ProducerConsumer(2);
        Thread t1= new Thread(() -> {
            try {
                pc.produce();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
           try {
               pc.consume();
           } catch(InterruptedException e) {

           }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
