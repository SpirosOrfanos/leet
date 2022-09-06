package onwork.easy;

//https://leetcode.com/problems/first-letter-to-appear-twice/submissions/

public class FirstLetterToAppearTwice {
    public static void main(String[] args) {
        FirstLetterToAppearTwice app = new FirstLetterToAppearTwice();
    System.out.println(app.repeatedCharacter("abccbaacz"));
    }

    public char repeatedCharacter(String s) {
        int[] ar = new int[256];
        for (int i = 0; i< s.length(); i++) {
            if (ar[s.charAt(i)] == 0) ar[s.charAt(i)] = -2;
            else if (ar[s.charAt(i)] == -2) ar[s.charAt(i)] = i;
        }
        int first = Integer.MAX_VALUE;
        char res = 'a';
        for (int i = 0; i<ar.length; i++) {
            if (ar[i]>0 && ar[i]<first) {
                res = (char)i;
                first = ar[i];
            }
        }
        return res;
    }

}
