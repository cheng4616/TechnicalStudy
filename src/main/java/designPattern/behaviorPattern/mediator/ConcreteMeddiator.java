package designPattern.behaviorPattern.mediator;

public class ConcreteMeddiator implements Mediator {

    private ColleagueA colleagueA;

    public ConcreteMeddiator(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }

    @Override
    public void operator() {
        colleagueA.methodA();
    }
}
