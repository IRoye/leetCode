package leetcode;


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 线程的顺序打印
 */

class ZeroEvenOdd {

    //  定义三个信号量
//  打印0的最先开始，一开始就是可以随意执行的，其他的阻塞
    private static Semaphore semaphoreZero = new Semaphore(1);
    //   打印奇数的第二个开始，那么需要设置为0，也就是说，需要首先获取permits，even才能打印
    private static Semaphore semaphoreEven = new Semaphore(0);
    //    和偶数同理，需要首先获取permits，才能打印，需要前一个释放一个信号量，所以，这里也是0
    private static Semaphore semaphoreOdd = new Semaphore(0);

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreZero.acquire();
//      0是开始，直接打印
            System.out.println("0");
//        释放一个semaphoreEven，释放了even才能开始
            if (i % 2 == 0) {
                semaphoreEven.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!(i % 2 == 0)) {

//       获取一个even的信号量，可以执行
                semaphoreEven.acquire();
                System.out.println(1);
//      释放一个odd，开始执行
                semaphoreZero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                semaphoreOdd.acquire();
                System.out.println(2);
                semaphoreZero.release();
            }
        }
    }

//    public static void main(String[] args) {
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
//
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.zero();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.even();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                zeroEvenOdd.odd();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }

}
