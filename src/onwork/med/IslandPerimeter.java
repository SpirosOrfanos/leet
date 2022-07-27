package onwork.med;

//https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {


    public static void main(String[] args) {
        IslandPerimeter app = new IslandPerimeter();
        int[][] grid = {
                {1}
        };
        System.out.println(app.islandPerimeter(grid));
    }
    public int islandPerimeter(int[][] grid) {
        int mRow = grid.length;
        int mCol = grid[0].length;
        int max = 0;
        for (int i = 0; i<mRow; i++) {
            for (int j =0; j<mCol; j++) {
                if (grid[i][j] == 1) {
                   max += addUp(i-1, j,mRow, mCol, grid) +
                           addDown(i+1, j,mRow, mCol, grid)+
                           addLeft(i, j-1,mRow, mCol, grid) +
                           addRight(i, j+1,mRow, mCol, grid);
                }
            }
        }
        return max;
    }
    public void islandPerimeter(int row, int col, int mRow, int mCol, int[][] grid) {

    }
    private boolean inLimit(int row, int col, int mRow, int mCol) {
        return (row>=0 && col>=0 && row<mRow && col<mCol);
    }

    int addUp(int row, int col, int mRow, int mCol, int[][] grid) {
        if (row<0) return 1;
        if (inLimit(row, col, mRow, mCol) && grid[row][col] == 0) return 1;
        return 0;
    }

    int addDown(int row, int col, int mRow, int mCol, int[][] grid) {
        if (row>=mRow) return 1;
        if (inLimit(row, col, mRow, mCol) && grid[row][col] == 0) return 1;
        return 0;
    }

    int addLeft(int row, int col, int mRow, int mCol, int[][] grid) {
        if (col<0) return 1;
        if (inLimit(row, col, mRow, mCol) && grid[row][col] == 0) return 1;
        return 0;
    }

    int addRight(int row, int col, int mRow, int mCol, int[][] grid) {
        if (col>=mCol) return 1;
        if (inLimit(row, col, mRow, mCol) && grid[row][col] == 0) return 1;
        return 0;
    }
}
