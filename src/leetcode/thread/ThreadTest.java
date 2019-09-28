package leetcode.thread;

public class ThreadTest {

    public Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        // 代码块
        synchronized (lock) {
            printFirst.run();
            lock.notifyAll();
        }
    }

    synchronized public void test(){
        System.out.println("test");
    }

    synchronized public static void test1(){
        System.out.println("test1");
    }
}
