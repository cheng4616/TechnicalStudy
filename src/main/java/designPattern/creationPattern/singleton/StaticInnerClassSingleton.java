package designPattern.creationPattern.singleton;

/**
 * 静态内部类：采用类装载的机制保证初始化时只有一个线程
 */
public final class StaticInnerClassSingleton {

    private static class SingletonInstance {
        public static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
