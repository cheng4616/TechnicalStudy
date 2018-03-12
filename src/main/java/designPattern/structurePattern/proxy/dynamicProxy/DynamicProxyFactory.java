package designPattern.structurePattern.proxy.dynamicProxy;

import designPattern.structurePattern.proxy.staticProxy.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 利用JDK的API,动态的在内存中构建代理对象
 */
public class DynamicProxyFactory {

    private UserDao target;

    public DynamicProxyFactory(UserDao target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before source");
                        Object resultObject = method.invoke(target, args);
                        System.out.println("after source");
                        return resultObject;
                    }
                }
        );
    }

}
