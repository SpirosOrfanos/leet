package y2021.mockassesment;
import java.util.*;
/*

Given an array nums of distinct integers,
return all the possible permutations.
You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

 */
public class AllPermutations {
    public static void main(String... args) {
        AllPermutations app = new AllPermutations();
    app.permute(new int[] {1,2,3,4}).forEach(i -> System.out.println(i));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        permute(nums, 0, res);
        return res;
    }
    public void permute(int[] nums, int pos,
                        List<List<Integer>> answer) {

        if (pos == nums.length) {
            List<Integer> soFar = new LinkedList<>();
            for (int i:nums) soFar.add(i);
            answer.add(soFar);
        }
        for (int i = pos; i<nums.length; i++) {
            swap(nums, pos, i);
            permute(nums, pos+1, answer);
            swap(nums, pos, i);
        }


    }
    void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
