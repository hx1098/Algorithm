package leetcode.learning.T_07_HeapAndComprator;

import java.util.*;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/1/12 6:28
 * @description 比较器
 * @editUser hx
 * @editTime 2022/1/12 6:28
 * @editDescription
 */
public class T_01_Comparator {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 4, 6, 8, 1, 9};
        System.out.println("排序前:");
        Arrays.stream(integers).forEach(System.out::print);
        System.out.println();

        System.out.println("排序后:");
        Arrays.sort(integers, new CustomComparator());
        Arrays.stream(integers).forEach(System.out::print);

        System.out.println();
        System.out.println("========================");
        Person p1 = new Person(3, "lisi", 23);
        Person p2 = new Person(6, "wangwu", 25);
        Person p3 = new Person(1, "zhangsan", 67);
        Person p4 = new Person(7, "liliu", 12);
        Person p5 = new Person(2, "hanfei", 2);
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        Collections.sort(personList, new PersonComparator());
        personList.stream().forEach(x -> {
            System.out.println(x.toString());
        });


        TreeMap<String, Object> treeMap = new TreeMap<>(new PersonComparator());
        TreeMap<String, Object> treeMap2 = new TreeMap<>();


        Set<Integer> integerSet = new TreeSet<>((a, b) -> a - b);
        //默认是小根堆,
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(5);
        priorityQueue.add(5);
        priorityQueue.add(5);
        //5
        //System.out.println(priorityQueue.peek());

        priorityQueue.add(6);
        priorityQueue.add(7);
        System.out.println(priorityQueue.peek());


    }


}

class PersonComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Person) o1).getId() - ((Person) o2).getId();
    }
}

class CustomComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return (Integer) o1 - (Integer) o2;
    }
}

