package y2022_3.easy;

import java.util.Stack;

public class MergeSortedArrays {
    public static void main(String... args) {
        MergeSortedArrays app = new MergeSortedArrays();
        int [] nums1 = {2,0};//{1,2,3,0,0,0};
        int m = 1;
        int [] nums2 = {1};//{2,5,6};
        int n = 1;
        app.merge(nums1, m, nums2, n);
        for (int i = 0; i< nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0)  {
            return;
        }
        if (n == 0)  {
            return;
        }
        if (m == 0)  {

            for (int i = 0; i<nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }


        int current = nums1[0]<nums2[0] ? nums1[0] : nums2[0];

        int n1Cnt = 0;
        int n2Cnt = 0;
        Stack<Integer> stack = new Stack<>();
        while (n1Cnt<m && n2Cnt<n) {
            while (n1Cnt<=m-1 && nums1[n1Cnt]<=current) {
                stack.add(nums1[n1Cnt++]);
            }

            while (n2Cnt<=n-1 && nums2[n2Cnt]<=current) {
                stack.add(nums2[n2Cnt++]);
            }

            if (n1Cnt==m) break;
            if (n2Cnt==n) break;

            current = nums1[n1Cnt]<nums2[n2Cnt] ? nums1[n1Cnt] : nums2[n2Cnt];

        }

        while (n1Cnt<=m-1) {
            stack.add(nums1[n1Cnt++]);
        }
        while (n2Cnt<=n-1) {
            stack.add(nums2[n2Cnt++]);
        }
        for(int i = stack.size()-1; i>=0; i--) {
            nums1[i]  =stack.pop();
        }


    }
}
