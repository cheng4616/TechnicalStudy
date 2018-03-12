package designPattern.structurePattern.proxy.staticProxy;

public class UserDaoProxy implements UserDao {

    private UserDaoImpl target;

    public UserDaoProxy() {
        this.target = new UserDaoImpl();
    }

    @Override
    public void save() {
        System.out.println("before save");
        target.save();
        System.out.println("after save");

    }
}
