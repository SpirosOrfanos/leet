package y2022.mid;

import java.util.*;
public class MergeiNTERVALS {

    public static void main(String[] args) {
        MergeiNTERVALS app = new MergeiNTERVALS();
        app.merge(new int[][] {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}});
    }

    public int[][] merge(int[][] intervals) {
        Stack<Internal> res = new Stack();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]>o2[0] ? 1 : o1[0]==o2[0] ? 0 : -1;
            }
        });



        for (int [] interval : intervals) {
            if(res.isEmpty() || res.peek().end<interval[0])
                res.add(new Internal(interval[0], interval[1]));
            else {
                res.peek().end = res.peek().end > interval[1] ? res.peek().end :interval[1] ;
            }
        }
        int[][] rr = new int[res.size()][2];
        int count = 0;
        for (Internal internal : res) {
            rr[count][0] = internal.start;
            rr[count][1] = internal.end;
            count++;
        }
        return rr;
    }

}

class Internal implements Comparable<Internal>{
    Internal(int start, int end) {
        this.start = start;
        this.end = end;
    }
    int start;
    int end;



    @Override
    public int compareTo(Internal o) {
        return this.start<o.start ? -1 : this.start == o.start ? 0 : 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Internal{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }
}
