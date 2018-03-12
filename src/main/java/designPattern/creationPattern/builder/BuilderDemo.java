package designPattern.creationPattern.builder;


/**
 * 建造者模式例子
 * 将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 *
 */
public class BuilderDemo {

    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.constructProduct(new ConcreteBuilder());
        System.out.println("product build." + product);
    }
}
