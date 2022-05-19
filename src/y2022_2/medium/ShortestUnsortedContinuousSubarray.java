package y2022_2.medium;

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String... args) {
        ShortestUnsortedContinuousSubarray app = new ShortestUnsortedContinuousSubarray();
    System.out.println(app.findUnsortedSubarray(new int[]{2,3,3,2,4})); //[2,3,3,2,4]
    }
    public int findUnsortedSubarray(int[] nums) {
        boolean[] check  = new boolean[nums.length];
        int min = nums[0];
        int minPos = 0;

        int max = nums[nums.length-1];
        int maxPos = nums.length-1;

        for (int i = 1; i< nums.length; i++) {
            if (nums[i]<min) {
                minPos = i;
                break;
            }
            min = nums[i];
        }

        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i]>max) {
                maxPos = i;
            }
            max = nums[i];
        }
        System.out.println();

        int start = 0;
        int end = nums.length-1;

        while(start<nums.length-1){
            if(nums[start]>nums[start+1]){
                break;
            }
            start++;
        }
        if(start == nums.length-1) return 0;

        while(end>0){
            if(nums[end]<nums[end-1]){
                break;
            }
            end--;
        }
        System.out.println();
/*
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i< nums.length; i++) {
            if (nums[i]<max) {
                check[i] = true;
                check[i-1] = true;
            }
            max = Math.max(max, nums[i]);
           // current = nums[i];
        }

        int start = 0;
        int end = nums.length-1;
        boolean startFound = false;
        boolean endFound = false;
        while (start<end ) {
            if (check[start]) {
                startFound = true;
            }
            if (check[end]) {
                endFound = true;
            }

            if (startFound && endFound) break;
            if(!startFound)start++;
            if (!endFound) end--;
        }
        int res = (end-start);
        res = res<=0 ? 0 : res+1;*/
        return 0;
    }

}
