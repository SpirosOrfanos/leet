package onwork.easy;

//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        FirstUniqueCharacterInString app = new FirstUniqueCharacterInString();
    System.out.println(app.firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        int[] ar = new int[256];

        for (int i = 0; i<s.length(); i++) {
            if (ar[s.charAt(i)] > 0) ar[s.charAt(i)] = -1;
            else if (ar[s.charAt(i)] == -1) continue;
            else ar[s.charAt(i)] = i+1;
        }

        int first = Integer.MAX_VALUE;
        for (int i: ar) {

            if (i>0 && i<first) first = i;
        }
        return first == Integer.MAX_VALUE ?-1 :first-1;
    }
}
