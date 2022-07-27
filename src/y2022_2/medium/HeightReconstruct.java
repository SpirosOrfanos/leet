package y2022_2.medium;

import java.util.*;

//https://leetcode.com/problems/queue-reconstruction-by-height/
public class HeightReconstruct {

    public static void main(String... args) {


        int[][] arr = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}};


        HeightReconstruct app = new HeightReconstruct();
        app.reconstructQueue2(arr);



    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                int cmp=arr2[0]-arr1[0];
                if(cmp==0) return arr1[1]-arr2[1];
                return cmp;
            }
        });

        LinkedList<int[]> list=new LinkedList<>();
        for(int[] arr:people){
            list.add(arr[1], arr);
        }
        return list.toArray(new int[people.length][]);
    }

}
