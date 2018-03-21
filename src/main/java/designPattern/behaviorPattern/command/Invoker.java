package designPattern.behaviorPattern.command;

/**
 * 调用者角色：接收到命令，并执行命令
 */
public class Invoker {
    public void execute(Command command) {
        command.execute();
    }
}
