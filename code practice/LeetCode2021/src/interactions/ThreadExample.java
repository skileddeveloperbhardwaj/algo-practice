package interactions;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t;
        Runnable r = new CountRunnable();
        for(int i=0;i<100;i++) {
            t = new Thread(r);
            t.start();
        }
    }

}

class CountRunnable implements Runnable {

    private volatile int i = 0;
    @Override
    public void run() {
        count();
    }
    public synchronized void count() {
        System.out.println(++i+"   "+Thread.currentThread().getName());
    }
}
