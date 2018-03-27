package designPattern.behaviorPattern.State;

public class BlackVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteContext voteContext) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
