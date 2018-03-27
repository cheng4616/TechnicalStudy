package designPattern.behaviorPattern.State;

public class Client {
    public static void main(String[] args) {
        VoteContext voteContext = new VoteContext();
        for (int i = 0; i < 10; i++) {
            voteContext.vote("liu", "A");
        }
    }
}
