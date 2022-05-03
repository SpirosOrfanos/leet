package y2022_2.medium;

public class GasStation {
    public static void main(String... args) {
        GasStation app = new GasStation();
        int [] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
    System.out.println(app.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i<n ; i++) {
            boolean visited[] = new boolean[n];
            int count = 0;
            int cur = i;
            int total = 0;
            while (count<n && total>=0) {
                count++;
                total+=gas[cur]-cost[cur];
                if (total<0) break;
                visited[cur] = true;
                if(allVisited(visited)) return i;
                if (cur == n-1)  {
                    cur=0;
                } else {
                    cur++;
                }
            }
        }
        return -1;
    }

    public boolean allVisited(boolean[] b) {
        for (boolean i : b) {
            if (!i) return i;
        }
        return true;

    }


}
