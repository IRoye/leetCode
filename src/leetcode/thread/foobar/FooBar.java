package leetcode.thread.foobar;

/***
 * Exception in thread "main" java.lang.IllegalMonitorStateException
 * 当某个线程试图等待一个自己并不拥有的对象（O）的监控器或者通知其他线程等待该对象（O）的监控器时
 * 首先必须获得监控器对象
 */
public class FooBar {

    private int n;

    private volatile int flag = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            if (flag == 0) {
                printFoo.run();
                flag = 1;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            if (flag == 1) {
                printBar.run();
                flag = 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1;
        FooBar fooBar = new FooBar(num);

        fooBar.bar(new PrintBar());
        fooBar.foo(new PrintFoo());


    }
}
