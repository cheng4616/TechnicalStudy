package designPattern.creationPattern.abstractFactory;


import designPattern.creationPattern.factoryMethod.Sender;

/**
 * 将factory也抽象出来，针对接口编程
 * <p>
 * <p>
 * 其实这个模式的好处就是，如果你现在想增加一个功能：
 * 发及时信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 */
public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
