package leetcode.thread.foobar;

public class PrintFoo implements Runnable {
    @Override
    public void run() {
        System.out.println("foo");
    }
}
