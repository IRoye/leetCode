package leetcode;

import java.util.concurrent.Semaphore;

/**
 *  H2O 生成
 */
public class H2O {

    private static Semaphore semaphoreH = new Semaphore(2);
    private static Semaphore semaphoreO = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
         semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        semaphoreO.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}
