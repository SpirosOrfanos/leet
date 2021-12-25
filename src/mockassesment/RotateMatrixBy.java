package mockassesment;

import java.util.*;

public class RotateMatrixBy {
    public static void main(String... args) {
        int [][] arr = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36},
        };
        RotateMatrixBy app = new RotateMatrixBy();
        app.rotate(arr);

        for (int i = 0; i<6; i++) {
            for (int j = 0; j< 6; j++) {
                System.out.print(arr[i][j] + (arr[i][j]>10 ?" " : "  "));
            }
            System.out.println();
        }
    }

    public void rotate(int[][] arr) {
        List<Queue<Integer>> qList = new ArrayList<>();
        int in = arr.length/2;
        int size = arr.length;
        for (int i = 0; i<in; i++) {
            Queue<Integer> q = new LinkedList<>();
            int rightRow = i;
            for (int j=i; j< size-i; j++) {
                q.add(arr[rightRow][j]);
            }
            int downCol = size-i-1;
            for (int j=i+1; j<size-i; j++){
                q.add(arr[j][downCol]);
            }
            int leftRow = size-i-1;
            for (int j=size-i-2; j>=i; j--){
                q.add(arr[leftRow][j]);
            }
            int upCol = i;
            for (int j = size-i-2; j>i; j--) {
                q.add(arr[j][upCol]);
            }
            qList.add(q);
        }

        for (int i = 0; i<size/2; i++) {
            Queue<Integer> qq = qList.get(i);
            int row = i;
            for (int c =i+1; c< size-i; c++){
                if (qq.isEmpty()) break;
                arr[row][c] = qq.poll();
            }
            int col = size-i-1;
            for (int r = i+1; r<size-i; r++) {
                if (qq.isEmpty()) break;
                arr[r][col] = qq.poll();
            }

            row = size-1-i;
            for (int c = size-2-i; c>=i; c--) {
                if (qq.isEmpty()) break;
                arr[row][c] = qq.poll();
            }
            col = i;
            for (int r = size-i -2; r>=i; r--) {
                if (qq.isEmpty()) break;
                arr[r][col] = qq.poll();
            }

        }
    }
}
