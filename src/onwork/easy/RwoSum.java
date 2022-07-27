package onwork.easy;

//https://leetcode.com/problems/two-sum/

import java.util.*;
public class RwoSum {
    public static void main(String[] args) {
        RwoSum app = new RwoSum();
        int[] ar = new int[]{2,7,11,15};
        int target = 9;

    System.out.println(app.twoSum(ar, target));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndiceMap = new HashMap<>();
        int rem = 0;
        for (int i = 0; i<nums.length; i++) {
            rem = target - nums[i];
            if (valueIndiceMap.get(rem)!=null) {
                return new int[] { valueIndiceMap.get(rem), i};
            }
            valueIndiceMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
