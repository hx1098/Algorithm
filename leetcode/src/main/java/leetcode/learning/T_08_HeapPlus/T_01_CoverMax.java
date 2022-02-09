package leetcode.learning.T_08_HeapPlus;

import javax.management.MXBean;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/2/9 9:56
 * @description
 * @editUser hx
 * @editTime 2022/2/9 9:56
 * @editDescription 最小线段树
 * 题目: 给定很多的线段,每个线段都有很多的数组[start,end],
 * 标识线段开始位置和结束位置, 左右都是闭区间,规定:
 * 1.线段的开始和结束位置一定都是整数值,
 * 2.线段的中核区域长度必须>=1, 返回线段最多的重合区域中, 包含了几条线段.
 *
 *
 */
public class T_01_CoverMax {

    public static int maxCover(int[][] m) {
        //先将所有线段放入到数组中
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines,new LineComparator());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            //不为空,并且
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class Line{
        public int start;
        public int end;
        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static class LineComparator implements Comparator<Line>{
        @Override
        public int compare(Line o1, Line o2) {
            return o1.end - o2.end;
        }
    }


    //for test
    public static void main(String[] args) {

    }


}
