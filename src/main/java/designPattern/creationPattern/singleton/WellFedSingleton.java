package designPattern.creationPattern.singleton;

/**
 * 饱汉式：利用双重检查(double-check)避免多线程下生成多个实例的情况
 */
public final class WellFedSingleton {

    private static volatile WellFedSingleton instance;

    private WellFedSingleton() {
    }

    public static WellFedSingleton getInstance() {
        if (instance == null) {
            synchronized (WellFedSingleton.class) {
                if (instance == null) {
                    instance = new WellFedSingleton();
                }
            }
        }
        return instance;
    }

}
