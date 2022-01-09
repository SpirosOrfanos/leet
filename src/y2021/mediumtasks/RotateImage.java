package y2021.mediumtasks;

public class RotateImage {
    public static void main(String... args) {
        int[][]arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        RotateImage app = new RotateImage();
        app.print(arr);
        app.rotate(arr);
    System.out.println();
        app.print(arr);
    }

    public void rotate(int[][] matrix) {
        int tmp ;
        int tmp2;
        int tmp3;
        int tmp4;
        int mx = matrix.length;
        int i = 0;
        int j = matrix.length-1;
        for (int pos = 0; pos<matrix.length/2; pos++) {
            for (int k = 0+pos; k<mx -1-pos; k++) {
                tmp  = matrix[i][k];
                tmp2 = matrix[k][j];
                tmp3 = matrix[j][j-k+pos];
                tmp4 = matrix[j-k+pos][i];
                matrix[k][j] = tmp;
                matrix[j][j-k+pos] = tmp2;
                matrix[j-k+pos][i] = tmp3;
                matrix[i][k] = tmp4;
            }
            i++;
            j --;
        }
    }

    public void print(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i< rows; i++) {
            for (int j = 0; j< cols; j++) {
            System.out.print(matrix[i][j] + "" + (matrix[i][j] <10 ? "  " : " "));
            }

        System.out.println();
        }
    }
}
