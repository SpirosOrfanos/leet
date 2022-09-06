package onwork.med;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max = 0;
        int[] arr = new int[256];
        for (int i = 0, j = 0; j<s.length(); j++) {
            i = Math.max(i, arr[s.charAt(j)]);
            max = Math.max(max, j-i+1);
            arr[s.charAt(j)] = j+1;
        }
        return max;
    }


}


