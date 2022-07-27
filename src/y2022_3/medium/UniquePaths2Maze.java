package y2022_3.medium;
//https://leetcode.com/problems/unique-paths-ii/submissions/

public class UniquePaths2Maze {
    public static void main(String... args) {
        UniquePaths2Maze app = new UniquePaths2Maze();
        int[][] maze= {
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0}
        };
        app.uniquePathsWithObstacles(maze);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;

        boolean[][] keep = new boolean[rows][cols];
        int[][] ob = new int[rows][cols];
        ob[0][0] = 1;
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    keep[i][j] = true;
            }
        }
        for (int i = 1; i<cols; i++) {
            if (keep[0][i]) {ob[0][i]=0; continue;}
            ob[0][i] = ob[0][i-1];
        }
        for (int i = 1; i<rows; i++) {
            if (keep[i][0])  {ob[i][0]=0; continue;}
            ob[i][0] = ob[i-1][0];
        }
        for (int i = 1; i<rows; i++) {
            for (int j = 1; j<cols; j++) {
               // if (i == 0 && j ==0) continue;
                if (keep[i][j])  {
                    ob[i][j] = 0;
                    continue;
                }
                ob[i][j] = ob[i-1][j] + ob[i][j-1];
            }
        }

    //System.out.println(ob[rows-1][cols-1]);

        return ob[rows-1][cols-1];
    }
}
