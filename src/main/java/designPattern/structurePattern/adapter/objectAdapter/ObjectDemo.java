package designPattern.structurePattern.adapter.objectAdapter;


import designPattern.structurePattern.adapter.classAdapter.Mobile;
import designPattern.structurePattern.adapter.classAdapter.Voltage220;

public class ObjectDemo {
    public static void main(String[] args) {
        System.out.println("\n===============对象适配器==============");
        ObjectAdapter objectAdapter = new ObjectAdapter(new Voltage220());
        Mobile mobile = new Mobile();
        mobile.charging(objectAdapter);
    }
}
