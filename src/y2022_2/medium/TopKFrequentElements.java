package y2022_2.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String... args) {
        TopKFrequentElements app = new TopKFrequentElements();
        int[] ar = {1,1,1,1,1,2,2,3,3,3,3,3};
        int[] t = app.topKFrequent(ar, 2);
        for (int j : t) System.out.println(j);
    }
    public int[] topKFrequent(int[] nums, int k) {
        List<Map.Entry<Integer, Integer>> m = Arrays.stream(nums).boxed()
                .collect(Collectors.toMap(v -> v, v->1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1>o2 ? -1 : o1.equals(o2)  ? 0 : 1;
                    }
                }))
                .limit(k)
                .collect(Collectors.toList())
                ;
        List<Integer> set = m.stream().map(v -> v.getKey()).collect(Collectors.toList());
        if (set.size()<=k) {
            int[] s = new int[set.size()];
            for (int i = 0; i<set.size(); i++) {
                s[i] = set.get(i);
            }
            return s;
        }

        int[] s = new int[k];
        for (int i = 0; i<k; i++) {
            s[i] = set.get(i);
        }

        return s;
    }
}

