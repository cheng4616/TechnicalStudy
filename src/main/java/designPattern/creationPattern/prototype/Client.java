package designPattern.creationPattern.prototype;

/**
 * 使用原型的客户端
 * 浅拷贝：Object类的clone方法只会拷贝java中的8中基本类型以及他们的封装类型，另外还有String类型。
 * 对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。
 * 如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
 *
 *
 *
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype operation() {
        return prototype.clone();
    }
}
