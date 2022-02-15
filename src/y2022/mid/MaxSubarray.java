package y2022.mid;

public class MaxSubarray {
    public static void main(String[] args) {
        MaxSubarray app = new MaxSubarray();
        app.maxProduct(new int[]{2,3,-2,4});
    }

    public int maxProduct(int[] nums) {
        int l = nums[0];
        int lsf = nums[0];
        int r = nums[nums.length -1];
        int rsf = nums[nums.length -1];

        for (int i=1; i< nums.length; i++) {
            l = (l==0 ? 1 : l)*nums[i];
            lsf = Math.max(l, lsf);
            r = (r==0 ? 1: r) * nums[nums.length -1-i];
            rsf = Math.max(r, rsf);
        }
        return rsf>lsf ? rsf : lsf;
    }
}
