package designPattern.behaviorPattern.strategy;

public class Client {

    public static void main(String[] args) {

        Context context = new Context(new AddStrategy());

        System.out.println(context.calulate(2, 3));

    }
}
