package thread.service.impl;

import thread.domain.MyOneList;
import thread.service.MyService;



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
