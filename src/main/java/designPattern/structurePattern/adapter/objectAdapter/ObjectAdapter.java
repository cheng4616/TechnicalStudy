package designPattern.structurePattern.adapter.objectAdapter;


import designPattern.structurePattern.adapter.classAdapter.Voltage220;
import designPattern.structurePattern.adapter.classAdapter.Voltage5;

/**
 * 对象适配器模式：持有src源，实现目标接口
 * 持有 src类，实现 dst 类接口，完成src->dst的适配
 */
public class ObjectAdapter implements Voltage5 {

    private Voltage220 voltage220;

    public ObjectAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5V() {
        int dst = 0;
        if (null != voltage220) {
            int src = voltage220.output220V();
            System.out.println("对象适配器工作，开始适配电压");
            dst = src / 44;
            System.out.println("适配完成后输出电压：" + dst);
        }
        return dst;
    }
}
