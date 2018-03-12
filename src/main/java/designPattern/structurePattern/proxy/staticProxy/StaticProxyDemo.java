package designPattern.structurePattern.proxy.staticProxy;

/**
 * 代理模式则偏向于委托类的访问限制
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoProxy();
        userDao.save();
    }
}
