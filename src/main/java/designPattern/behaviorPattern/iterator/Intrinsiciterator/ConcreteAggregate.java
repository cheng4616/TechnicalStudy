package designPattern.behaviorPattern.iterator.Intrinsiciterator;

/**
 * 　具体聚集角色类，实现了抽象聚集角色所要求的接口，也就是createIterator()方法。此外，聚集类有一个内部成员类ConcreteIterator，
 * 这个内部类实现了抽象迭代子角色所规定的接口；而工厂方法createIterator()所返还的就是这个内部成员类的实例。
 */
public class ConcreteAggregate extends Aggregate {

    private Object[] objects = null;

    public ConcreteAggregate(Object[] objects) {
        this.objects = objects;
    }


    @Override
    public Iterator createIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator {
        //内部索引，记录当前迭代到的索引位置
        private int index = 0;
        //记录当前聚集对象的大小
        private int size = 0;

        public ConcreteIterator() {
            this.size = objects.length;
            index = 0;
        }


        @Override
        public void first() {
            index = 0;
        }

        @Override
        public void next() {
            if (index < size) {
                index++;
            }
        }

        @Override
        public boolean isDone() {
            return (index >= size);
        }

        @Override
        public Object currentItem() {
            return objects[index];
        }
    }


}
