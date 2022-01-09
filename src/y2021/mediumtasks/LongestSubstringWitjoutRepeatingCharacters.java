package y2021.mediumtasks;

public class LongestSubstringWitjoutRepeatingCharacters {

    public static void main(String... args) {
        LongestSubstringWitjoutRepeatingCharacters app = new LongestSubstringWitjoutRepeatingCharacters();
        System.out.println(app.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) return 0;
        int[] observer = new int[128];
        int max = 0;
        for (int i = 0,j = 0; j<s.length(); j++) {
            i = Math.max(observer[s.charAt(j)], i);
            max = Math.max(max, j-i+1);
            observer[s.charAt(j)] = j+1;
        }
        return max;
    }
}
