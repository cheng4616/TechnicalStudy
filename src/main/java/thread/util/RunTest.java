package thread.util;


import thread.domain.MyOneList;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */
public class RunTest {

    public static void main(String[] args) {
        try {
            MyOneList myOneList = new MyOneList();

            MyThread1 thread1 = new MyThread1(myOneList);
            thread1.setName("thread-A");
            thread1.start();

            MyThread2 thread2 = new MyThread2(myOneList);
            thread2.setName("thread-B");
            thread2.start();
            Thread.sleep(200);
            System.out.println("myOneList.getSize():" + myOneList.getSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
