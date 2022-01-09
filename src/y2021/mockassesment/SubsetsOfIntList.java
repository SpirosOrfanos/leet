package y2021.mockassesment;

import java.util.*;

public class SubsetsOfIntList {
    public static void main(String... args) {
        SubsetsOfIntList app = new SubsetsOfIntList();
        List<List<Integer>> sets = app.subsets(new int[] {1, 2, 3});
        for (List<Integer> i : sets)  {
            System.out.println(i);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void subsets(int[] nums, int pos, List<List<Integer>> sets, List<Integer> cur) {
        if (pos  <= nums.length-1) return;
        sets.add(new ArrayList<>(cur));
        for (int i = pos; i< nums.length; i++) {
            cur.add(nums[i]);
            subsets(nums, i+1, sets, cur);
            cur.remove(cur.size()-1);
        }

    }

}
