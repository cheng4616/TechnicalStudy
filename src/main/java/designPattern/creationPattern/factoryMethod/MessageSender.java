package designPattern.creationPattern.factoryMethod;

public class MessageSender implements Sender {
    @Override
    public void send() {
        System.out.println("sending Message.");
    }
}
