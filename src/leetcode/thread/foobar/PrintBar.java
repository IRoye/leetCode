package leetcode.thread.foobar;

public class PrintBar implements Runnable {
    @Override
    public void run() {
        System.out.println("bar");
    }
}
