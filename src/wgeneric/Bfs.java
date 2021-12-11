package wgeneric;

import java.util.*;
public class Bfs {
    public static void main(String... args) {
        Bfs app = new Bfs();



        int [] arr = {1,1,1,1};
    System.out.println(app.jump(arr));
    }

    public int jump(int[] nums) {
        if(nums.length ==1 || nums[0] == 0) return 0;
        int[] array = nums;
        int[][] data = createArray(array);

        List<BfsNode> createGraph = createGraph(data);
        Queue<BfsNode> q = new LinkedList<>();
        q.add(createGraph.get(0));

        boolean[] visited = new boolean[array.length];
        int jump = 0;
        while (!q.isEmpty()) {
            List<BfsNode> nns = new LinkedList<>();
            while(!q.isEmpty()) {
                nns.add(q.poll());
            }
            jump++;
            for (BfsNode bfsNode:nns) {
                if (bfsNode.val>=nums.length)  {
                    return jump;
                }
                if (!visited[bfsNode.val-1]) {
                    visited[bfsNode.val-1] = true;
                    for (BfsNode nds:bfsNode.neighbours) {
                        if (nds.val >= nums.length)
                            return jump;
                        if (!visited[nds.val-1]) {
                            q.add(createGraph.get(nds.val-1));
                        }
                    }
                }
            }

        }
        return 0;
    }

    private int [][] createArray(int[] arr) {
        int [][] res = new int[arr.length][arr.length];
        for (int i = 0; i<arr.length; i++) {
            if (i == arr.length-1) {
                res[i] = new int[]{i+1};
                return res;
            }
            int size = arr[i];
            if (size == 0) {
                res[i] = new int[]{i+1};
                continue;
            }

            int[] nr = new int[size+1];
            nr[0] = i+1;
            for (int j = 1; j<=size; j++){
                nr[j] = i+1+j;
            }
            res[i] = nr;
        }
        return res;
    }

    private List<BfsNode> createGraph(int[][] data) {
        List<BfsNode> list = new LinkedList<>();
        for (int i = 0; i< data.length; i++) {
            BfsNode node = new BfsNode();
            node.val = data[i][0];
            if (data[i].length>0) {
                for (int j = 1; j< data[i].length; j++) {
                    BfsNode neighbour = new BfsNode();
                    neighbour.val = data[i][j];
                    node.neighbours.add(neighbour);
                }
            }

            list.add(node);
        }
        return list;
    }


}

class BfsNode{
    int val = -1;
    List<BfsNode> neighbours = new LinkedList<>();
}