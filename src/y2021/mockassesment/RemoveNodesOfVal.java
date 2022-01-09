package y2021.mockassesment;


import y2021.wgeneric.utils.TreeNode;

import java.util.*;

public class RemoveNodesOfVal {
    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        RemoveNodesOfVal app = new RemoveNodesOfVal();
        app.flatten(root);

    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        List<Integer> val = new LinkedList();
        flatten(root, val, root.val);
        TreeNode tr = new TreeNode(val.get(0));
        TreeNode tr2 = tr;
        for (int i = 1; i < val.size(); i++) {
            tr.right = new TreeNode(val.get(i));
            tr.left = null;
            tr = tr.right;
        }
        root.left = tr2.left;
        root.right = tr2.right;
    }

    public void flatten(TreeNode root, List<Integer> list, Integer v) {
        if (root == null)  {
            return;
        }

        if (v!=null) list.add(v);
        if (root.left!=null) flatten(root.left, list, root.left.val);
        if (root.right!=null) flatten(root.right, list, root.right.val);
    }



    void remoNodes() {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next  = new ListNode(2);
        a1.next.next.next  = new ListNode(1);
        ListNode l = removeElements(a1, 2);
        System.out.println();
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head!=null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode next = head;
        while (next!=null) {
            if (next.val == val) {
                prev.next = next.next;
            } else {
                prev = next;
            }
            next = next.next;
        }
        if (head.val == val) head = head.next;
        return head;
    }
}
