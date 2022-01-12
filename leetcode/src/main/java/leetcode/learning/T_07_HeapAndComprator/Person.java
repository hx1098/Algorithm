package leetcode.learning.T_07_HeapAndComprator;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/12 13:19
 * @description
 * @editUser hx
 * @editTime 2022/1/12 13:19
 * @editDescription
 */
public class Person {

    private int id;
    private String name;
    private int age;

    public Person( ) {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
