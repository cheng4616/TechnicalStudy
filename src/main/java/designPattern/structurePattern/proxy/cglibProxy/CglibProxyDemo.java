package designPattern.structurePattern.proxy.cglibProxy;

public class CglibProxyDemo {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象的方法
        proxy.save();

    }
}
