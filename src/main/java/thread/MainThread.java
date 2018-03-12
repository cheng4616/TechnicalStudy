package thread;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月11日       TODO
 * </pre>
 */
public class MainThread {

    /**<p>Description TODO</p>
     * @author liuzhicheng
     * @date 2017年5月11日 下午2:07:17
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ThreadBaseTest());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("wait for ThreadBaseTest!");
    }

}
