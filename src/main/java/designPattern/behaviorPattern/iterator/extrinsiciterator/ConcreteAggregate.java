package designPattern.behaviorPattern.iterator.extrinsiciterator;

/**
 * 具体聚集角色类，实现了抽象聚集角色类所要求的接口，也就是createIterator()方法。此外，还有方法getElement()向外界提供聚集元素，而方法size()向外界提供聚集的大小等。
 */
public class ConcreteAggregate extends Aggregate {

    private Object[] objects = null;

    /**
     * 构造方法，传入聚合对象的具体内容
     */
    public ConcreteAggregate(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    /**
     * 取值方法：向外界提供聚集元素
     */
    public Object getElement(int index) {

        if (index < objects.length) {
            return objects[index];
        } else {
            return null;
        }
    }

    /**
     * 取值方法：向外界提供聚集的大小
     */
    public int size() {
        return objects.length;
    }


}
