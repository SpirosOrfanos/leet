package y2022.mid;

import java.awt.*;
import java.util.LinkedList;
import java.util.*;
import java.util.List;

public class RottingOranges {
    public static void main(String... args) {
        RottingOranges app = new RottingOranges();
        app.orangesRotting(new int[][] {{0,2}/*{2,1,1},
                                        {1,1,0},
                                        {0,1,1}*/
                                        });
    }
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
        boolean b[][] = new boolean[grid.length][grid[0].length];
        int total = 0;
        int polluted = 0;
        int fresh = 0;
        int hours = 0;
        Queue<P> points = new LinkedList<>();
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2)  {
                    polluted++;
                    //b[i][j] = true;
                    points.add(new P(i, j));
                }
            }
            total = fresh+polluted;
        }

        while (!points.isEmpty() && fresh>0) {
            List<P> list = new ArrayList<>();
            while (!points.isEmpty() && fresh>0) {
                P p = points.poll();
                if (!b[p.x][p.y]) {
                    list.add(p);

                }
            }
            for (P p : list) {
                if (!b[p.x][p.y]) {
                    b[p.x][p.y] = true;
                }
                for (int[] d:dir) {
                    if (isInBorderAndNotEmpty(grid, p, d[0], d[1], fresh)) {
                        points.add(new P(p.x+d[0], p.y+d[1]));
                        fresh--;
                    }
                }
            }
            hours++;
        }
   //System.out.println(hours);
        return fresh == 0 ? hours : -1;
    }

    private boolean isInBorderAndNotEmpty(int[][] grid, P p, int x, int y, Integer fresh) {
        if ((p.x+x>=0 && p.x+x<grid.length) &&
                (p.y+y>=0 && p.y+y<grid[0].length) &&
                grid[x+p.x][y+p.y] ==  1) {
            grid[x+p.x][y+p.y] = 2;
           // fresh --;
            return true;
        }
        return false;
    }

    private class P {
        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
}
