package designPattern.behaviorPattern.strategy;

/**
 * 编写策略类，该类实现了上面的公共接口。
 */
public class AddStrategy implements Strategy {
    @Override
    public int calculate(int number1, int number2) {
        return number1 + number2;
    }
}
