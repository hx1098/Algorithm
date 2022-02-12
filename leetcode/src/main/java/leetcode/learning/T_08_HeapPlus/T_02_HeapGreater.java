package leetcode.learning.T_08_HeapPlus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/10 9:25
 * @description
 * @editUser hx
 * @editTime 2022/2/10 9:25
 * @editDescription  加强堆的实现
 */
public class T_02_HeapGreater<T> {

    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;//索引
    private int heapSize;
    private Comparator<? super T> comp;

    public T_02_HeapGreater(Comparator<? super T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }
    public int size() {
        return heapSize;
    }
    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }
    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    private void heapInsert(int i) {
        
    }

}
