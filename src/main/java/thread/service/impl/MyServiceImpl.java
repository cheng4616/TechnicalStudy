package payment.thread.test.service.impl;

import javax.xml.ws.ServiceMode;

import payment.thread.test.domain.MyOneList;
import payment.thread.test.service.MyService;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */

public class MyServiceImpl implements MyService {

    public MyOneList addServiceMethod(MyOneList myOneList, String data) {
        try {
            // list中只能存一个元素
            synchronized (myOneList) {
                if (myOneList.getSize() < 1) {
                    Thread.sleep(2000); // 模拟从远程2s取到数据
                    myOneList.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myOneList;
    }

}
