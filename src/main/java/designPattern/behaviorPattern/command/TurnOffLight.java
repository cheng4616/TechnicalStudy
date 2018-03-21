package designPattern.behaviorPattern.command;

public class TurnOffLight extends Command {

    private Receiver receiver;

    public TurnOffLight(Receiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute() {
        receiver.turnOffLight();
    }
}
