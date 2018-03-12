package designPattern.structurePattern.proxy.staticProxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save data");
    }
}
