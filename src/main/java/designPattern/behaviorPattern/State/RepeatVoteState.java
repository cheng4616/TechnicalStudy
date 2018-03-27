package designPattern.behaviorPattern.State;

/**
 * 重复投票
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteContext voteContext) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}
