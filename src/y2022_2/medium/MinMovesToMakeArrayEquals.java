package y2022_2.medium;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

public class MinMovesToMakeArrayEquals {
    public static void main(String... args) {
        MinMovesToMakeArrayEquals app = new MinMovesToMakeArrayEquals();
    System.out.println(app.minMoves(new int[]{1,0,0,8,6}));
    }

    public int minMoves(int[] nums) {
        if(nums.length <2) return 0;
        Arrays.sort(nums);
        if(nums[0] == nums[nums.length-1]) return 0;
        int max = Integer.MAX_VALUE;
        for (int j = 0; j<nums[nums.length-1]; j++) {
            int firstCase = 0;
            for (int i:nums) {
                firstCase += Math.abs(i-j);
            }
            max = Math.min(max, firstCase);
        }
        return max;
    }
}
