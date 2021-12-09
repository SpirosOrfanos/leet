package mediumtasks;

import java.util.*;
public class MergeIntervals {

    public static void main(String... args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        /*{
                {1,3},
                {2, 4},
                {1, 2}
        };*/
        MergeIntervals app = new MergeIntervals();
        app.merge(intervals);


    }

    public int[][] merge(int[][] intervals) {
        List<Internal> internals = new LinkedList<>();

        for (int[] intr : intervals) internals.add(new Internal(intr[0], intr[1]));
        Collections.sort(internals);
        System.out.println(internals);

        List<Internal> res = new LinkedList<>();
        res.add(internals.get(0));
        for (int i = 1;i<internals.size(); i++) {
            Internal temp = internals.get(i);
            Internal test = res.get(res.size()-1);
            if (test.end>=temp.start) {
                if (test.end<temp.end) {
                    res.get(res.size()-1).end = temp.end;
                }
            } else {
                res.add(temp);
            }
        }

        int[][] result = new int[res.size()][2];
        int count = 0;
        for (Internal rss : res) {
            result[count][0] = rss.start;
            result[count][1] = rss.end;
            count++;
        }
        return result;
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



