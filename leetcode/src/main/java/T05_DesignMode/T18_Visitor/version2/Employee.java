package T05_DesignMode.T18_Visitor.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/28 9:27
 * @description 访问者模式
 * @editUser hx
 * @editTime 2021/10/28 9:27
 * @editDescription 在一个单位里谁都员工, 不管你是部门经理还是小兵
 */
public abstract class Employee {

    /**
     * 0代表男性
     */
    public static final int MALE = 0;

    /**
     * 1代表女性
     */
    public static final int FEMAILE = 1;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 薪水
     */
    private int salary;

    /**
     * 性别
     */
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    /**我允许一个访问者进行访问*/
    public abstract void accept(IVisitor visitor);

    /**打印出员工的信息*//*
    public final void report() {
        String info = "姓名：" + this.name + "\t";
        info = info + "性别：" + (this.sex == FEMAILE ? "女" : "男") + "\t";
        info = info + "薪水：" + this.salary + "\t";
        //获得员工的其他信息
        info = info + this.getOtherInfo();
        System.out.println(info);
    }*/


    /**拼装员工的其他信息*/
    /*protected abstract String getOtherInfo();*/
}
