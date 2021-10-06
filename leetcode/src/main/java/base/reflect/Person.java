package base.reflect;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2021/10/5 14:33
 * @description
 * @editUser hx
 * @editTime 2021/10/5 14:33
 * @editDescription
 */
public class Person {



    private String nmme;

    private String age;

    private String birthday;

    public Person() {

    }

    public String getNmme() {
        return nmme;
    }

    public void setNmme(String nmme) {
        this.nmme = nmme;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    private Person(String nmme, String age, String birthday) {
        this.nmme = nmme;
        this.age = age;
        this.birthday = birthday;
    }
    public Person(String amme, String age) {
    }



    public String show() {
        return "name:" + this.nmme + "age:" + age;
    }
}
