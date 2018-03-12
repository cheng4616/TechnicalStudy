package designPattern.behaviorPattern.strategy;

/**
 * 在使用策略对象的类中保存一个对策略对象的引用。在使用策略对象的类中，实现对策略对象的set和get方法或者使用构造方法完成赋值。
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calulate(int a, int b) {
        return strategy.calculate(a, b);
    }
}
