package y2022_2.medium;


public class LongestSubsrringWithoutrepeating {
    public static void main(String... args) {
        LongestSubsrringWithoutrepeating app = new LongestSubsrringWithoutrepeating();
        System.out.println(app.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        int[] arr = new int[128];
        for (int i=0, j=0; j<s.length(); j++) {
            int p = (int) s.charAt(j);
            i = Math.max(i, arr[p]);
            max = Math.max(max, j-i+1);
            arr[p] = j+1;

        }

        return max;
    }
}
