package y2022.asses;

import helper.TreeNode;

public class SolutionA {
    public static void main(String... args) {
        SolutionA a = new SolutionA();
        a.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

    public void bstFromPreorder(int[] preorder) {

        TreeNode root = helper(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);

    }
    int ind = 0;
    public TreeNode helper(int[] l, int hi, int lo){
        if(ind >= l.length){return null;}
        if(l[ind] < hi && l[ind] > lo){
            TreeNode node = new TreeNode(l[ind]);
            ind ++;
            node.left = helper(l, node.val, lo);
            node.right = helper(l, hi, node.val);
            return node;
        }else{return null;}
    }



/*
Given an integer n, return true if and only if it is an Armstrong number.

The k-digit number n is an Armstrong number if and only if the kth power of each digit sums to n.

Example 1:
Input: n = 153
Output: true
Explanation: 153 is a 3-digit number, and 153 = 13 + 53 + 33.

Example 2:
Input: n = 123
Output: false
Explanation: 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
 */
    public boolean isArmstrong(int n) {
        int tmp = n;
        int poq = (n+"").length();
        while (n>0) {
            int curr = (n%10);
            tmp-= (int)Math.pow(curr, poq);
            n/=10;
            if (tmp<0) return false;
        }
        return tmp == 0;

    }
}
