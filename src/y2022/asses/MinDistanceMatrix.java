package y2022.asses;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceMatrix {
    static int[][] adj = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static void main(String... args) {
        int[][] maze = {
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,9,0},
                {0,0,0,0,0},
        };
        MinDistanceMatrix app = new MinDistanceMatrix();
        System.out.println(app.sol(maze));

    }


    int sol(int[][] maze) {
        int mx = maze.length;
        int my = maze[0].length;
        Queue<Pos> q = new LinkedList();
        maze[0][0] = 1;
        q.add(new Pos(0, 0, 0));

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            if(maze[pos.x][pos.y] == 9) {
                System.out.println("found");
                return pos.steps;
            }
            maze[pos.x][pos.y] = 1;
            for(int[] arr :adj) {
                if(addIt(maze, pos.x+arr[0], pos.y+arr[1], mx, my)) {
                    q.add(new Pos(pos.x+arr[0], pos.y+arr[1], pos.steps+1));
                }
            }
        }
        return -1;
    }

    private boolean addIt(int[][]maze, int x, int y, int mx, int my) {
        if (x>=0 && y>=0 && x<mx && y<my && maze[x][y]!=1) return true;
        return false;
    }
    static class Pos {
        int x; int y; int steps;

        public Pos(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}