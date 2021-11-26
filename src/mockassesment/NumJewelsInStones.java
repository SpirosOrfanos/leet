package mockassesment;

import java.util.HashSet;
import java.util.Set;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".



Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 */
public class NumJewelsInStones {
    public static void main(String... args) {
        NumJewelsInStones app = new NumJewelsInStones();
    System.out.println(app.numJewelsInStones("bcd", "cba"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        if(jewels == null || jewels.length() == 0) return 0;
        Set<Integer> jes = new HashSet();
        char[] j = jewels.toCharArray();
        for (char c: j) {
            jes.add((int)c);
        }
        int left = 0;
        int right = stones.length()-1;

        int count = 0;
        while (left<right) {
            if(jes.contains((int)stones.charAt(left)))
                count++;
            if(jes.contains((int)stones.charAt(right)))
                count++;
            left++;
            right--;
        }
        if (stones.length()%2 != 0) {
            left = (stones.length()/2);
            if(jes.contains((int)stones.charAt(left)))
                count++;
        }
        return count;
    }



}
