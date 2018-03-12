package designPattern.creationPattern.factoryMethod;

/**
 * 工厂方法模式  创建对象实例
 * 缺点：类的创建依赖于工程类
 */
public class SendFactory {
    public Sender sendMail() {
        return new MailSender();
    }

    public Sender sendMessage() {
        return new MessageSender();
    }

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = null;
        String type = "Message";
        if ("Mail".equals(type)) {
            sender = sendFactory.sendMail();
        } else if ("Message".equals(type)) {
            sender = sendFactory.sendMessage();
        } else {
            sender = sendFactory.sendMail();
        }
        sender.send();
    }

}
