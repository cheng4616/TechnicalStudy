package designPattern.behaviorPattern.chainofresponsibility;

public class Client {

    public static void main(String[] args) {

        Handler handler1 = new ConceteHandler();
        Handler handler2 = new ConceteHandler();
        Handler handler3 = new ConceteHandler();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        handler1.handleRequest();
    }
}
