package y2022.mid;

import java.util.*;

public class ContiguousArray {
    public static void main(String... args) {
        ContiguousArray app = new ContiguousArray();
    System.out.println(app.findMaxLength(new int[] {0,0,0,1,1,1}));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++) {
            sum+=(nums[i]==0?-1:1);
            Integer index = map.get(sum);
            if(index!=null) {
                max=Math.max(i-index,max);
            } else {
                map.put(sum,i);
            }
        }
        return max;
    }
}
