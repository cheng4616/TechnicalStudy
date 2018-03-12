package designPattern.structurePattern.decorator;


/**
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例。
 * 装饰器模式的应用场景：
 * 1、需要扩展一个类的功能。
 * 2、动态的为一个对象增加功能，而且还能动态撤销。
 */
public class SourceWrapper implements Sourceable {
    private Source source;

    public SourceWrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before source method");
        source.method();
        System.out.println("after source method");
    }
}
