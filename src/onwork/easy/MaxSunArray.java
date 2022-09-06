package onwork.easy;

import org.omg.CORBA.INTERNAL;

public class MaxSunArray {
    public static void main(String[] args) {
        MaxSunArray app = new MaxSunArray();
        int[] in = {-2, -3, 4, -1, -2, 1, 5, -3};
    System.out.println(app.maxSubArray(in));
    }


    /*
    int max = nums[0];
		int max1 = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i]>(max+nums[i])) {
				max = nums[i];
			} else {
				max+=+nums[i];
			}

			if(max1<max) max1=max;
		}
        return max1;
     */
    public int maxSubArray(int[] in) {
        if(in.length ==1) return in[0];
        int max = in[0];
        int soFar = in[0];

        for (int i = 1; i<in.length; i++) {
            soFar = Math.max(soFar+in[i], in[i]);
            max = Math.max(max, soFar);
        }
        return max;
    }
}
