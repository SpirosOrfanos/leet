package mediumtasks;

import java.util.*;

public class CombinationSum {
    public static void main(String... args) {
        CombinationSum app = new CombinationSum();
    System.out.println(app.combinationSum(new int[]{2,3,6,7}, 7));
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList(), res, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, List<Integer> current, List<List<Integer>> res, int index) {

        if(target ==0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i< candidates.length; i++) {
            if (target-candidates[i]<0) continue;
            current.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], current, res, i);
            current.remove(current.size()-1);
        }
    }

}
