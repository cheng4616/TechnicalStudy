package designPattern.creationPattern.builder;

/**
 * 构造一个使用Builder接口的对象
 */
public class Director {
    public Product constructProduct(Builder builder) {
        builder.buildBasic();
        builder.buildWalls();
        builder.roofed();
        return builder.buildProduct();
    }
}
