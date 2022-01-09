package y2021.wgeneric.utils;


// create TSPExample class to implement TSP code in Java
class TSPExample
{
    // create findHamiltonianCycle() method to get minimum weighted cycle
    static int findHamiltonianCycle(int[][] distance, boolean[] visitCity, int currPos, int cities, int count, int cost, int hamiltonianCycle, int dest)
    {

        if (count == cities && distance[currPos][0] > 0 )
        {
            hamiltonianCycle = Math.min(hamiltonianCycle, cost + distance[currPos][0]);
            return hamiltonianCycle;
        }

        // BACKTRACKING STEP
        for (int i = 0; i < cities; i++)
        {
            if (visitCity[i] == false && distance[currPos][i] > 0)
            {

                // Mark as visited
                visitCity[i] = true;
                hamiltonianCycle = findHamiltonianCycle(distance, visitCity, i, cities, count + 1, cost + distance[currPos][i], hamiltonianCycle, dest);

                // Mark ith node as unvisited
                visitCity[i] = false;
            }
        }
        return hamiltonianCycle;
    }

    static int tsp(int[][] graph, boolean[] v,
                   int currPos, int n,
                   int count, int cost, int ans)
    {

        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (v[i] == false && graph[currPos][i] > 0) {
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1,(cost + graph[currPos][i]), ans);

                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        return ans;
    }

    // main() method start
    public static void main(String[] args)
    {
        int cities = 4;
        /*int distance[][] = {
                {0,1,1,0},
                {1,0,2,1},
                {1,2,0,0},
                {0,1,0,0}
        };*/

        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};


        // create an array of type boolean to check if a node has been visited or not
        boolean[] visitCity = new boolean[cities];

        // by default, we make the first city visited
        visitCity[0] = true;


        int ans = Integer.MAX_VALUE;

        // call findHamiltonianCycle() method that returns the minimum weight Hamiltonian Cycle
        ans = tsp(distance, visitCity, 0, cities, 1, 0, ans);
       // ans = tsp(distance, visitCity, 0, cities, 1, 0, ans);
        // print the minimum weighted Hamiltonian Cycle
        System.out.println(ans);
    }
}
