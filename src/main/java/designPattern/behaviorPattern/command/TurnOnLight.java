package designPattern.behaviorPattern.command;

public class TurnOnLight extends Command {

    private Receiver receiver;

    public TurnOnLight(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOnLight();
    }
}
