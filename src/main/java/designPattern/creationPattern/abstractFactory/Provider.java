package designPattern.creationPattern.abstractFactory;


import designPattern.creationPattern.factoryMethod.Sender;

/**
 * 提供一个工厂类接口
 */
public interface Provider {

    public Sender produce();

}
