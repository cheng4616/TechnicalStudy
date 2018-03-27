package designPattern.behaviorPattern.visitor;

/**
 * 抽象被访问者：公司员工抽象类
 */
public abstract class Employee {

    /**
     * 接收/引用一个抽象访问者对象
     *
     * @param department
     */
    public abstract void accept(Department department);

}
