package designPattern.creationPattern.prototype;

/**
 * Java实现原型模式的两个要点：
 * 1、实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。
 * 在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出 CloneNotSupportedException异常。
 * 2、重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，
 * 一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。
 */
public class ConcretePrototypeJava implements Cloneable {

    @Override
    public ConcretePrototypeJava clone() {
        ConcretePrototypeJava concretePrototypeJava = null;
        try {
            concretePrototypeJava = (ConcretePrototypeJava) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return concretePrototypeJava;
    }
}
