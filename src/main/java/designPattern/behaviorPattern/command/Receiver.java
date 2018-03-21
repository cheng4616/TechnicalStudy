package designPattern.behaviorPattern.command;

/**
 * 接受者角色：该角色就是干活的角色，命令传递到这里是应该被执行的
 */
public class Receiver {

    public void turnOnLight() {
        System.out.println("turn on the light");
    }

    public void turnOffLight() {
        System.out.println("turn off the light");
    }
}
