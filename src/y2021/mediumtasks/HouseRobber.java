package y2021.mediumtasks;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String... args) {
        HouseRobber app = new HouseRobber();
      //  System.out.println(app.rob(new int[] {1,2,3,1,1}));
     //   System.out.println(app.rob(new int[] {1,2,3,1}));
        System.out.println(app.rob(new int[] {2,1,1,2}));

    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0]+nums[2], nums[1]);
        nums[1] = Math.max(nums[1], nums[0]);
        nums[2] = Math.max(nums[2]+nums[0], nums[1]);
        int max = Math.max(nums[2], nums[1]);
        for( int i = 3; i< nums.length; i++) {
            max = Math.max(nums[i]+nums[i-2], nums[i-1]);
            nums[i] = max;
        }
        return  max;
    }


}
