package designPattern.behaviorPattern.visitor;

public class HRDepartment extends Department {
    /**
     * 访问公司管理者对象的每月实际上班时长统计
     */
    @Override
    public void visit(ManagerEmployee me) {
        me.getTotalTimeSheet();
    }

    /**
     * 访问公司普通员工对象的每月实际上班时长统计
     */
    @Override
    public void visit(GeneralEmployee ge) {
        ge.getTotalTimeSheet();
    }
}
