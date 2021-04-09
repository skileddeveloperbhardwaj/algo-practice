package multithread;

//Double checking locking in Singleton
public class DoubleCheckingLockingSingleton {
    private static volatile DoubleCheckingLockingSingleton _instance;

    public DoubleCheckingLockingSingleton getInstance() {
        if(_instance == null) {
            synchronized (DoubleCheckingLockingSingleton.class) {
                if(_instance == null) {
                    _instance = new DoubleCheckingLockingSingleton();
                }
            }
        }
        return _instance;
    }

}
