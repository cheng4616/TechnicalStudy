package designPattern.creationPattern.abstractFactory;

import designPattern.creationPattern.factoryMethod.MailSender;
import designPattern.creationPattern.factoryMethod.Sender;


public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
