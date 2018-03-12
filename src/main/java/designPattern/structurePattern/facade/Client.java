package designPattern.structurePattern.facade;

/**
 * Facade模式定义了一个高层接口，这个接口使得这子系统更容易使用。
 */
public class Client {
    public static void main(String[] args) {
        DrawerFacade drawer = new DrawerFacade();
        drawer.open();
    }
}


class DrawerFacade {
    DrawerOne darwerOne = new DrawerOne();
    DrawerTwo darwerTwo = new DrawerTwo();

    public void open() {
        darwerOne.open();
        darwerTwo.open();
    }
}


class DrawerOne {
    public void open() {
        System.out.println("第一个抽屉被打开了");
        getKey();
    }

    public void getKey() {
        System.out.println("得到第二个抽屉的钥匙");
    }
}

class DrawerTwo {
    public void open() {
        System.out.println("第二个抽屉被打开了");
        getFile();
    }

    public void getFile() {
        System.out.println("得到这个重要文件");
    }
}