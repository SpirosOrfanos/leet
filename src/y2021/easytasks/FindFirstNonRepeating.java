package y2021.easytasks;

import java.util.HashSet;
import java.util.Set;

public class FindFirstNonRepeating {
    public static void main(String... args) {
        FindFirstNonRepeating app = new FindFirstNonRepeating();
    System.out.println(app.firstUniqChar2("bac"));
    }
    public int firstUniqChar(String s) {

        int[] ids = new int[128];
        boolean[] idsb = new boolean[128];
        Set<Integer> pq = new HashSet<>();
        int count = 0;
        for (char c:s.toCharArray()) {
            if (!idsb[c]) {
                pq.add((int)c);
                ids[c] = count;
                idsb[c] = true;
            } else {
                pq.remove((int)c);
            }

            count++;
        }
        if(pq.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for (int i : pq) {
            if (ids[i]<min) min = ids[i];
        }
        return min;
    }

    public int firstUniqChar2(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }



}
