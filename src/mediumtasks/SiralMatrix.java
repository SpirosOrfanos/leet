package mediumtasks;

import java.util.*;
public class SiralMatrix {
    public static void main(String... args) {
        SiralMatrix app = new SiralMatrix();

        int[][] arr = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,16,17,28,29, 30},
                {31,32,33,34,35,36}
        };

       /* int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };*/
    app.check(new int[]{2,2,2,3,3});

    }

    private int check(int[] postion) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:postion) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        int even = 0;
        int odd = 0;
        for(Map.Entry<Integer, Integer> e:map.entrySet())  {
            if(e.getKey()%2 == 0) odd+=e.getValue();
            else  even+=e.getValue();
        }
        return Math.min(even, odd);
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int rStart = 0; int rEnd = matrix.length;
        int downStart = 1; int downEnd = matrix.length-1;
        int leftStart = matrix.length-1; int leftEnd = matrix.length-2;
        int upStart =  matrix.length-2; int upEnd = 0;
        int count = matrix.length * matrix.length;

        int rem = 0;
        while(count>0) {
            for (int i = rStart; i< rEnd && count>0;  i++) {
                count--;
                res.add(matrix[rStart][rStart+i-rem]);
            }

            for (int i = downStart; i<=downEnd && count>0; i++) {
                count--;
                res.add(matrix[i][downEnd]);
            }

            for (int i = 0; i<=leftEnd-rem && count>0; i++) {
                count--;
                res.add(matrix[leftStart][leftEnd-i]);
            }

            for (int i = upEnd; i<upStart && count>0; i++) {
                count--;
                res.add(matrix[upStart-i][upEnd]);
            }
            rStart++;
            rEnd--;

            downStart++;
            downEnd--;

            leftStart--;
            leftEnd--;

            upStart--;
            upEnd++;
            rem++;

        }
        return res;
    }

}
