package designPattern.structurePattern.adapter.interfaceAdapter;

public class InterfaceAdapterDemo {

    public static void main(String[] args) {
        Source source = new InterfaceClient();
        source.read();
    }
}
