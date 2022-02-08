package y2022.asses;

public class RichestCustomerWealth {
    public static void main(String[] args) {

    }

    public int maximumWealth(int[][] accounts) {

        int max = Integer.MIN_VALUE;
        for (int[] ar : accounts) {
            int cur = 0;
            for (int i: ar) {
                cur+=i;
            }
            if (cur>max) max = cur;
        }
        return max;
    }
}
