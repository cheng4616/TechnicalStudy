package designPattern.structurePattern.proxy.dynamicProxy;

import designPattern.structurePattern.proxy.staticProxy.UserDao;
import designPattern.structurePattern.proxy.staticProxy.UserDaoImpl;


public class DynamicProxyDemo {
    public static void main(String[] args) {
        UserDao target = new UserDaoImpl();
        System.out.println(target.getClass());
        UserDao proxy = (UserDao) new DynamicProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
