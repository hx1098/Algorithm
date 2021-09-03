package primer.T_005_comporator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hx
 * @createTime 2021/9/3 9:35
 * @version 1.0.0
 * @description 自定义comparator
 * @editUser hx
 * @editTime 2021/9/3 9:35
 * @editDescription
 */
public class ShowComparator {

    public static class Student{
        public String name;
        public int age;
        public int id;

        public Student(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 9, 2, 3, 6, 9, 0, 5, 7};
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        //进行排序
        System.out.println("======================================");


        Student s1 = new Student("zhangsan", 5, 6);
        Student s2 = new Student("lisi", 8, 5);
        Student s3 = new Student("wangwu", 3, 8);
        Student s4 = new Student("zhaoliu", 9, 1);
        Student s5 = new Student("luqi", 4, 2);
        Student[] students = {s1, s2, s3, s4, s5};
        printStudents(students);

        System.out.println("======================================");
        Arrays.sort(students,new IdComparator());
        printStudents(students);

        System.out.println("======================================");
        Arrays.sort(students,new ageComparator());
        printStudents(students);


        System.out.println("======================================");





    }

    private static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].id + ", " +students[i].age + ", " + students[i].name );
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static class IdComparator implements Comparator<Student> {

        //返回负数这默认为第一个参数应该排在前面
        //返回正数, 则认为第二个参数应该排在前面
        //返回为0, 则认为两个位置都一样
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return 1;
            } else if (o2.id < o1.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**按照年龄进行排序*/
    public static class ageComparator implements Comparator<Student> {
        //如果返回正数, 则第二个参数应该排在前面
        //如果返回负数, 则第一个参数应该泡在前面
        //如果返回了0, 不管
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }





}
