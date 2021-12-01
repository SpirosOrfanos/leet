package easytasks;

public class MajorityElement {
    public static void main(String... args) {
        MajorityElement app = new MajorityElement();
         app.majorityElement(new int[]{2,2,1,1,1,2,2});
         app.majorityElement(new int[]{3,2,3});
    }

    public int majorityElement2(int[] nums) {
        int maj = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; ++i) {
            if(maj==nums[i]) count++;
            else {
                if (count<0) {
                    count=1;
                    maj = nums[i];
                } else {
                    if (count ==1) maj = nums[i];
                    else count--;
                }
            }
        }
        count = 0;
        for(int i:nums) if(i == maj) count++;

        return count*2>nums.length ? maj: -1;
    }
    public int majorityElement(int[] nums) {

        int count = 1;
        int cur = nums[0];
        for (int i = 1; i< nums.length; i++) {
            if (cur == nums[i]) count++;
            else {
                if (count < 0) {
                    cur = nums[i];
                    count = 1;
                } else {
                    if (count ==1)   cur = nums[i];
                    else count--;

                }
            }
        }
       System.out.println(cur);
        return count;
    }

}
