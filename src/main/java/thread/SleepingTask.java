package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月11日       TODO
 * </pre>
 */
public class SleepingTask extends ThreadBaseTest {

    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                // 线程操作一般位于线程的run()方法中
                // Thread.sleep(100);
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }

}
