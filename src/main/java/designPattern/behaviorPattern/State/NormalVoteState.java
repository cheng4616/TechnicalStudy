package designPattern.behaviorPattern.State;

/**
 * 正常投票
 */
public class NormalVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteContext voteContext) {
        voteContext.getVoteMap().put(user, voteItem);
        System.out.println("投票成功！");
    }
}
