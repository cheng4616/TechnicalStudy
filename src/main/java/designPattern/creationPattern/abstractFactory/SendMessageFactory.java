package designPattern.creationPattern.abstractFactory;


import designPattern.creationPattern.factoryMethod.MessageSender;
import designPattern.creationPattern.factoryMethod.Sender;

public class SendMessageFactory implements Provider {
    @Override
    public Sender produce() {
        return new MessageSender();
    }
}
