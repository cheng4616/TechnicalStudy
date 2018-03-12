package designPattern.creationPattern.factoryMethod;

public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("sending mail.");
    }
}
