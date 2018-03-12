package payment.thread.test.util;

import payment.thread.test.domain.MyOneList;
import payment.thread.test.service.MyService;
import payment.thread.test.service.impl.MyServiceImpl;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */
public class MyThread1 extends Thread {

    private MyOneList myOneList;

    public MyThread1(MyOneList myOneList) {
        super();
        this.myOneList = myOneList;
    }
    
    public void run(){
        MyService myService = new MyServiceImpl();
        myService.addServiceMethod(myOneList, "A");
    }

}
