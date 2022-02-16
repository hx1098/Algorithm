package leetcode.learning.T_08_HeapPlus;

import com.sun.org.apache.xpath.internal.operations.And;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/10 9:25
 * @description
 * @editUser hx
 * @editTime 2022/2/10 9:25
 * @editDescription  加强堆的实现(利用了反向索引)
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

    public T pop() {
        T ans = heap.get(0);
        //和末尾位置作交换
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T obj) {
        //如果删除的的数据刚好是最后一个位置, 则不用调整位置.
        indexMap.remove(obj);
        heap.remove(--heapSize);

        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        //如果删除的的数据刚好不是最后一个位置.
        if (replace != obj) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            //重新调整整个堆结构
            resign(replace);
        }
    }

    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : ans) {
            ans.add(c);
        }
        return ans;
    }

    /*重新调整整个堆的位置.*/
    private void resign(T replace) {
        //调整位置的时候, 要末是往上移动的的, 要末世往下移动的.
        heapInsert(indexMap.get(replace));
        heapify(indexMap.get(replace));
    }

    private void heapify(int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            //有右节点, 且右节点大
            int best = left + 1 < heapSize && comp.compare(heap.get(left), heap.get(left + 1)) < 0 ? (left + 1) : left;
            //todo 看下这个compare == 0 , ==-1 时候到底是谁大谁小
            best = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (best == index) {
                break;
            }
            swap(best,index);
            index = best;
            left = 2 * index + 1;
        }
    }


    private void heapInsert(int index) {
        //(3-1)/2 是求出父节点
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //互换的时候将值换掉, 同时将反向索引也要换掉
    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(i);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }



}
