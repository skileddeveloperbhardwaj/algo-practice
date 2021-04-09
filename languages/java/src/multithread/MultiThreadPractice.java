package multithread;

public class MultiThreadPractice {
    public static void main(String[] args) {
        Thread t1 = new Thread("T1");
        Thread t2 = new Thread("T2");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}
