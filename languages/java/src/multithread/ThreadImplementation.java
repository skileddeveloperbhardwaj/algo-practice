package multithread;

public class ThreadImplementation implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable implementation");
    }

    public static void main(String[] args) {
        ThreadImplementation task = new ThreadImplementation();
        Thread t1 = new Thread(task);
        t1.start();
        t1.start();
        new Thread(task).start();
    }
}
