package designPattern.behaviorPattern.command;

public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        Command turnOn = new TurnOnLight(receiver);
        Command turnOff = new TurnOffLight(receiver);
        invoker.execute(turnOn);
        invoker.execute(turnOff);

    }
}
