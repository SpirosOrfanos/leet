package y2022.mid;

public class Geyness {
    public static void main(String[] args) {
        Geyness app = new Geyness();
        int[][] ii = {
                {1,0,1},
                {0,0,1},
                {1,1,0}
        };
    System.out.println(app.gScale(ii));
    }

    public int gScale(int [][] arr) {
        int[] ones = new int[arr.length];
        int[] zeros = new int[arr[0].length];

        int[] ones_c = new int[arr.length];
        int[] zeros_c = new int[arr[0].length];
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j<arr[0].length; j++) {
                if (arr[i][j] ==1) {
                    ones[i]++;
                    ones_c[i]++;
                 } else {
                    zeros[j]++;
                    zeros_c[j]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j<arr[0].length; j++) {
                max =  Math.max(max, ones[i] + ones_c[i] - (zeros[j]+zeros_c[j]));
            }

        }
        return max;
    }
}
