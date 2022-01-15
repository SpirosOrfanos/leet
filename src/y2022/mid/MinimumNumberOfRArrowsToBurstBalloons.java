package y2022.mid;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfRArrowsToBurstBalloons {
  public static void main(String... args) {
    MinimumNumberOfRArrowsToBurstBalloons app = new MinimumNumberOfRArrowsToBurstBalloons();
    System.out.println(app.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 9}, {7, 12}}));
  }

  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) return 0;
    Arrays.sort(
        points,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] > o2[1] ? 1 : o1[1] == o2[1] ? 0 : -1;
          }
        });

    int burst = 1;
    int startPoint = points[0][1];
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > startPoint) {
        startPoint = points[i][1];
        burst++;
      }
    }

    return burst;
  }
}
