package payment.thread.test.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liuzhicheng      2017年5月16日       TODO
 * </pre>
 */
public class MyOneList {

    private List<String> list = new ArrayList<String>();

    public void add(String data) {
        list.add(data);
    }

    public int getSize() {
        return list.size();
    }
}
