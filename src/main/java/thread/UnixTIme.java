package payment.thread.test;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */
public class UnixTIme {

    public static void main(String[] args) {

        Long NowTime = System.currentTimeMillis();

        System.out.println(NowTime);

        String strTime = "9999999999999";

        Long lastTime = Long.valueOf(strTime);

        System.out.println((lastTime - NowTime) / 365 / 24 / 3600 / 1000);
    }
}
