package designPattern.structurePattern.adapter.classAdapter;

/**
 * Client类：手机 .需要5V电压
 */
public class Mobile {

    public void charging(Voltage5 voltage5) {
        if (voltage5.output5V() == 5) {
            System.out.println("电压刚刚好5V，开始充电");
        } else if (voltage5.output5V() > 5) {
            System.out.println("电压超过5V，都闪开 我要变成note7了");
        }
    }

    public static void main(String[] args){
        System.out.println("===============类适配器==============");
        Mobile mobile = new Mobile();
        mobile.charging(new ClassAdapter());
    }
}
