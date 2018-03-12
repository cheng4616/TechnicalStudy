package payment.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月11日       test
 * </pre>
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec1;
        // 创建一个可变大小的线程池，最大为Integer的最大值，大的放到一个等待队列中。
        /* exec = Executors.newCachedThreadPool(); */
        // 创建一个固定大小的线程池，大于线程池大小的放到等待队列中，等待队列的最大值为2^31-1
        exec1 = Executors.newFixedThreadPool(2);

        // exec= Executors.newSingleThreadExecutor();

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 3; i++) {
            // if (i == 1) {
            // exec.schedule(new ThreadBaseTest(), 10, TimeUnit.SECONDS);
            // } else {
            //exec.scheduleAtFixedRate(new ThreadBaseTest(), 1, 4, TimeUnit.SECONDS);

            exec.scheduleWithFixedDelay(new ThreadBaseTest(), 1, 3, TimeUnit.SECONDS);
            
            
            // }
        }

    }
}
