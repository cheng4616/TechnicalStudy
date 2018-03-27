package designPattern.behaviorPattern.mediator;

public class ColleagueB extends Colleague {
    private ConcreteMeddiator concreteMeddiator;


    public void methodB() {
        concreteMeddiator.operator();
    }

    ;

}
