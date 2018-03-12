package designPattern.structurePattern.decorator;

/**
 * 装饰模式主要是强调对类中代码的拓展
 */
public class WrapperDemo {

    public static void main(String[] args) {
        Source source = new Source();
        Sourceable sourceable = new SourceWrapper(source);
        sourceable.method();
    }
}
