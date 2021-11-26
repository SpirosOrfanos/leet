package mediumtasks;

//https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindromicSubstring {
    public static void main(String... args) {
        LongestPalindromicSubstring app = new LongestPalindromicSubstring();
        //System.out.println( app.longestPalindrome("OLOCBABCOKO"));
        System.out.println(app.longestPalindrome("ac"));
      //  System.out.println(app.longestPalindrome("OCO"));
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() ==0 || s.length() ==1) return s;
        int max = 1;
        String rs = "";
        for (int i = 0; i< s.length(); i++) {
            int l = i;
            int r = i;
            int res = 1;
            while (l>=0 && r<s.length() && s.charAt(r) == s.charAt(l)) {
                if (r-l+1>max)  {
                    res = r-l+1;
                    rs = s.substring(l, r+1);
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while (l>=0 && r<s.length() && s.charAt(r) == s.charAt(l)) {
                if (r-l+1>max)  {
                    res = r-l+1;
                    rs = s.substring(l, r+1);
                }
                l--;
                r++;
            }
            max = Math.max(max, res);
        }

        return max == 1 ? ""+s.charAt(0): rs;
    }
}
