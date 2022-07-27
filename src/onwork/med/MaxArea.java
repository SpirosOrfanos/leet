package onwork.med;

//https://leetcode.com/problems/max-area-of-island/

public class MaxArea {
    public static void main(String[] args) {
        MaxArea app = new MaxArea();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
    System.out.println(app.maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int MAX = 0;
        for (int i = 0; i<maxRow; i++) {
            for (int j = 0; j<maxCol; j++) {
                if (grid[i][j] ==1 ) {
                    MAX = Math.max(MAX, reset(i, j, maxRow, maxCol, grid));
                }
            }
        }
        return MAX;
    }
    private int reset(int row, int col,
                       int maxRow, int maxCol, int[][] grid) {
        if (!inLimit(row, col, maxRow, maxCol) || (grid[row][col] == 0)) return 0;
       // if (grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return 1 + reset(row, col-1, maxRow, maxCol, grid)
                + reset(row, col+1, maxRow, maxCol, grid)
                + reset(row+1, col, maxRow, maxCol, grid)
                + reset(row-1, col, maxRow, maxCol, grid);

    }

    boolean inLimit(int row, int col,
        int maxRow, int maxCol) {
        return  row>=0
                && row<maxRow
                && col>=0
                && col<maxCol ;
    }


}


