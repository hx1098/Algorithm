package T05_DesignMode.T15_Composite.version2;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/22 16:07
 * @description
 * @editUser hx
 * @editTime 2021/10/22 16:07
 * @editDescription 定义一个公司的人员抽象类
 */
public abstract class Corp {

    /**公司每个人都有名臣*/
    private String name = "";

    /**公司每个人都职位*/
    private String position = "";

    /**公司每个人都有薪水*/
    private int salary = 0;


    public Corp(String _name,String _position,int _salary){
        this.name = _name;
        this.position = _position;
        this.salary = _salary;
    }

    /**
     * 获得员工信息
     * @return
     */
    public String getInfo(){
        String info = "";
        info = "姓名：" + this.name;
        info = info + "\t职位："+ this.position;
        info = info + "\t薪水：" + this.salary;
        return info;
    }





}
