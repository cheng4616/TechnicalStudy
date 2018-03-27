package designPattern.behaviorPattern.State;

/**
 * 抽象状态(State)角色：定义一个接口，用以封装环境（Context）对象的一个特定的状态所对应的行为。
 */
public interface VoteState {
    /**
     * 处理状态对应的行为
     *
     * @param user
     * @param voteItem
     * @param voteContext
     */
    public void vote(String user, String voteItem, VoteContext voteContext);
}
