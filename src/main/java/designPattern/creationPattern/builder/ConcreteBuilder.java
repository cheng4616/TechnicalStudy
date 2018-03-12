package designPattern.creationPattern.builder;

/**
 * 实现Builder的接口以构造和装配该产品的各个部件，定义并明确它所创建的表示，并提供一个检索产品的接口
 */
public class ConcreteBuilder implements Builder {

    private Product product;


    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildBasic() {
        product.setBasic("基础");
    }

    @Override
    public void buildWalls() {
        product.setWall("砌墙");
    }

    @Override
    public void roofed() {
        product.setRoofed("封顶");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
