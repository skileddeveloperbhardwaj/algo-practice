package multithreading;

public class NumberSequenceGenerator {

    public static void main(String[] args) {
        SequencePrinter runnable1 = new SequencePrinter(1);
        SequencePrinter runnable2 = new SequencePrinter(2);
        SequencePrinter runnable3 = new SequencePrinter(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");
        Thread t3 = new Thread(runnable3, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class SequencePrinter implements Runnable {
    private static volatile int number = 1;
    static Object lock = new Object();
    private int rem;

    public SequencePrinter(int r) {
        rem = r;
    }

    @Override
    public void run() {
        try {
            printSequence();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printSequence() throws InterruptedException {
        while (number < 10) {
            Thread.sleep(1000);
            synchronized (lock) {
                while (number % 3 != rem) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }

                System.out.println(Thread.currentThread().getName() + " " + number++);
                lock.notifyAll();
            }
        }
    }
}
