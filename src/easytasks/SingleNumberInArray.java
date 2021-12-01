package easytasks;
//https://leetcode.com/problems/single-number/
public class SingleNumberInArray {
    public int singleNumber(int[] nums) {
        int p = 0;
        for (int i : nums) p^=i;
        return p;
    }
}
