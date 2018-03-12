package designPattern.creationPattern.singleton;

/**
 * 饿汉式：在类加载时进行类的实例化（静态常量）缺点:不符合lazy loading(延迟加载)的原则。
 */
public final class HungrySingleton {

    //私有化构造函数
    private HungrySingleton() {
    }

    //静态化实例
    private static HungrySingleton INSTANCE = new HungrySingleton();

    //提供方法进行实例获取
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     *
     * @return
     */
    public Object readResolve() {
        return INSTANCE;
    }
}
