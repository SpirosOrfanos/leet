package helper;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void add(int val) {
        if (this.val == 0)  {
            this.val = val;
            return;
        }
        TreeNode temp = this;
        while (true) {
            if (temp.val>val) {
                if (temp.left != null)  {
                    temp = this.left;
                }
                else  {
                    temp.left = new TreeNode(val);
                    return;
                }
            } else {
                if (temp.right != null)  {
                    temp = this.right;
                } else  {
                    temp.right = new TreeNode(val);
                    return;
                }
            }
        }
    }

    public void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public void preorder(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        inOrder(node.left);
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.val);
    }
}
