package designPattern.creationPattern.prototype;

/**
 * ①是通过克隆来创建新的对象实例；②是为克隆出来的新的对象实例复制原型实例属性的值。
 */
public class ConcretePrototype implements Prototype {
    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype();
        return prototype;
    }
}
