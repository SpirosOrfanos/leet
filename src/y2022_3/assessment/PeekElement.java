package y2022_3.assessment;

import java.util.HashSet;
import java.util.Set;

/*

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.


Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

 */
public class PeekElement {
    public static void main(String... args) {
        int[] arr = {1,2,3};
        PeekElement app = new PeekElement();

        System.out.println(app.findPeakElement(arr));
    System.out.println(app.repeatedSubstringPattern("aa"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null ) return false;
        if(s.length() <2) return false;
        if(s.length() == 2) return s.toCharArray()[0] == s.toCharArray()[1];
        for (int i = 1; i<s.length()-1; i++) {
            if ( s.length()%i == 0) {
                Set<String> set = new HashSet();
                set.add(s.substring(0, i));
                for (int j = 0; j<s.length(); j+=i) {
                    set.add(s.substring(j, (j+i)));
                }
                if (set.size() == 1) return true;
            }
        }
        return false;
    }

    public int findPeakElement(int[] nums) {
        if (nums==null ||  nums.length <2 ) return 0;
        if (nums.length ==2) {
            if(nums[0]>nums[1]) return 0; else return 1;
        }
        for (int start=1, end = nums.length-2; start<=end; start++, end--) {

            if (start == end) {
                if (nums[start-1]<nums[start] && nums[start]>nums[start+1]) {
                    return start;
                }
            }
            if (nums[start-1]<nums[start] && nums[start]>nums[start+1]) {
                return start;
            }

            if (nums[end-1]<nums[end] && nums[end]>nums[end+1]) {
                return end;
            }

        }

        int peek = 0;
        int start = nums[0];
        for (int  i = 1; i<nums.length; i++) {
            if (nums[i]>start) {
                start = nums[i];
                peek = i;
            }
        }
        return peek;
    }
}
