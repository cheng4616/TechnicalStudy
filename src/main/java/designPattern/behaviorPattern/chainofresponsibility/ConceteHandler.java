package designPattern.behaviorPattern.chainofresponsibility;

/**
 * 具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。
 * 由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。
 */
public class ConceteHandler extends Handler {
    @Override
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理请求");
        }
    }
}
