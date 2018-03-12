package designPattern.structurePattern.decorator;

public class Source implements designPattern.structurePattern.decorator.Sourceable {
    @Override
    public void method() {
        System.out.println("this is source method");
    }
}
