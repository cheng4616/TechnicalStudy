package thread.util;


import thread.domain.MyOneList;
import thread.service.MyService;
import thread.service.impl.MyServiceImpl;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */
public class MyThread2 extends Thread {
    private MyOneList myOneList;

    public MyThread2(MyOneList myOneList) {
        super();
        this.myOneList = myOneList;
    }

    public void run() {
        MyService myService = new MyServiceImpl();
        myService.addServiceMethod(myOneList, "B");
    }

}
