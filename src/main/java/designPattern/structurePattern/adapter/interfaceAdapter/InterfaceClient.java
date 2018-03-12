package designPattern.structurePattern.adapter.interfaceAdapter;

public class InterfaceClient extends InterfaceAdapter {

    public void read() {
        System.out.println("实现read方法被调用");
    }

    public void write() {
        System.out.println("实现write方法被调用");
    }
}
