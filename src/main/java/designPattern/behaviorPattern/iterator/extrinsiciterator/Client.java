package designPattern.behaviorPattern.iterator.extrinsiciterator;

/**
 * 外禀迭代子
 */
public class Client {

    public void operation() {
        Object[] objects = {"One", "Two", "Three", "Four", "Five", "Six"};
        Aggregate aggregate = new ConcreteAggregate(objects);
        Iterator iterator = aggregate.createIterator();
        while (!iterator.isDone()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.operation();
    }

}
