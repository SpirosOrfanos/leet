package y2022_3.medium;

import java.util.Arrays;

public class AddTwoNumbers {
    int[][] arr = null;
    public static void main(String... args) {

        AddTwoNumbers app = new AddTwoNumbers();

    }

    /*public int bulbSwitch(int n) {
        int[][] arr = new int[n][n];
        boolean[] bulbs = new boolean[n];
        Arrays.fill(bulbs, true);
        int size = n;
        for (int s = 0; s < n-1; s++) {

            int count = s;
            for (int i=count+1; i<size; i+=2+count) {
                bulbs[i] = !bulbs[i];
            }
        }

        int res = 0;
    for (int i = 0; i < bulbs.length; i++)
        res = res + (bulbs[i] ? 1 : 0);

    return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rs=row1;
        int cs = col1;
        int re = row2;
        int ce = col2;
        int res = 0;
        for (int i = rs; i<=re; i++) {
            for (int j = cs; j<=ce; j++) {
                res+=arr[i][j];
            }
        }
        return res;
    }*/


}
