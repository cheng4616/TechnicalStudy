package designPattern.creationPattern.builder;

/**
 * 为创建一个产品对象的各个部件指定抽象接口。
 */
public interface Builder {

    public void buildBasic();

    public void buildWalls();

    public void roofed();

    public Product buildProduct();
}
