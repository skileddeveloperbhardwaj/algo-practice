package multithreading;

public class OddEvenSequence {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumber(1), "T1");
        Thread t2 = new Thread(new PrintNumber(0), "T2");
        t1.start();
        t2.start();
    }
}

class PrintNumber implements Runnable {
    private static int number = 1;
    private static Object lock = new Object();
    private int rem;

    public PrintNumber(int r) {
        rem = r;
    }

    @Override
    public void run() {
        printNumber();
    }

    private void printNumber() {
        while (number < 30) {
            synchronized (lock) {
                while (number % 2 != rem) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(Thread.currentThread().getName() + "  " + number++);
                lock.notifyAll();
            }
        }
    }
}