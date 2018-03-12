package payment.thread.test;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月11日       TODO
 * </pre>
 */
public class ThreadBaseTest implements Runnable {

    /** 计数器 */
    protected int countDown = 10;

    private int num = 0;

    private static int TASK_COUNT = 0;

    private final int id = TASK_COUNT++;

    public ThreadBaseTest() {
    }

    public ThreadBaseTest(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "countDown end!") + "),";
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (countDown-- > 0) {
            System.out.print(status());
            // 线程操作一般位于线程的run()方法中
            // Thread.yield();
        }
        num++;
        System.out.println("ThreadName: " + Thread.currentThread().getName() + " Num:" + num);

    }

}
