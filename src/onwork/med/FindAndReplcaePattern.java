package onwork.med;

//https://leetcode.com/problems/find-and-replace-pattern/submissions/


import java.util.*;

public class FindAndReplcaePattern {
    public static void main(String[] args) {
        FindAndReplcaePattern app = new FindAndReplcaePattern();

        String [] list = {
                "abc",
                "deq",
                "mee",
                "aqq",
                "dkd",
                "ccc"};

        System.out.println(app.findAndReplacePattern(list, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Map<Character, List<Integer>> pa = new HashMap<>();
        for (int i = 0; i< pattern.length(); i++) {
            char temp = pattern.charAt(i);
            if (pa.get(temp) == null) pa.put(temp, new ArrayList());
            pa.get(temp).add(i);
        }

        Set<Integer> s2 = new HashSet<>();
        for(Map.Entry<Character, List<Integer>> en:pa.entrySet()) {
            s2.add(Arrays.hashCode(en.getValue().toArray()));
        }
        for (String wo: words) {
            if (checkMe(s2.iterator(), wo)) res.add(wo);
        }
        return res;

    }

    boolean checkMe(Iterator<Integer> iterator, String word) {

        Map<Character, List<Integer>> wo = new HashMap<>();
        for (int i = 0; i< word.length(); i++) {
            char temp = word.charAt(i);
            if (wo.get(temp) == null) wo.put(temp, new ArrayList());
            wo.get(temp).add(i);
        }

        Set<Integer> s2 = new HashSet<>();
        for(Map.Entry<Character, List<Integer>> en:wo.entrySet()) {
            s2.add(Arrays.hashCode(en.getValue().toArray()));
        }

        while (iterator.hasNext()) {
            if(!s2.contains(iterator.next())) return false;
        }

        return true;
    }
}
