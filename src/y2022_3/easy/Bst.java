package y2022_3.easy;

import helper.TreeNode;
import java.util.*;

public class Bst {
    public static void main(String... args) {
        Bst app = new Bst();
        /*TreeNode rootAltered = new TreeNode(3);
        rootAltered.left = new TreeNode(1);
        rootAltered.right = new TreeNode(4);
        rootAltered.right.left = new TreeNode(2);*/
        TreeNode rootAltered = new TreeNode(1);
        rootAltered.left = new TreeNode(3);

        rootAltered.left.right = new TreeNode(2);
        app.recoverTree(rootAltered);
        System.out.println();
    }

    public void recoverTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int rootVal = root.val;
        int rootPos = 0;
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i) == rootVal) {
                rootPos = i;
                break;
            }
        }
        list.sort((o1, o2) -> o1.intValue()>o2.intValue() ? 1 : o1.intValue() ==             o2.intValue() ? 0 : -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<rootPos; i++) {
            stack.push(list.get(i));
        }

        TreeNode node = new TreeNode(list.get(rootPos));
        while (!stack.isEmpty()) {
            add(stack.pop(), node);
        }
        for (int i = rootPos; i<list.size(); i++) {
            stack.push(list.get(i));
        }
        while (!stack.isEmpty()) {
            add(stack.pop(), node);
        }
        root.val = node.val;
        root.left = node.left;
        root.right = node.right;
        System.out.println();
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public void add(int val, TreeNode root) {
        if (root.val == 0)  {
            root.val = val;
            return;
        }

        while (true) {
            if (root.val>val) {
                if (root.left != null)  {
                    root = root.left;
                }
                else  {
                    root.left = new TreeNode(val);
                    return;
                }
            } else {
                if (root.right != null)  {
                    root = root.right;
                } else  {
                    root.right = new TreeNode(val);
                    return;
                }
            }
        }
    }

    /*void binary(int[] arr) {
        TreeNode rootAltered = new TreeNode(3);
        rootAltered.left = new TreeNode(1);
        rootAltered.right = new TreeNode(4);
        rootAltered.right.left = new TreeNode(2);

        TreeNode root = new TreeNode();
        for(int i: arr) add(i, root);
        System.out.println();

        List<Integer> list = new ArrayList<>();
        inOrder(rootAltered, list);
        int rootVal = rootAltered.val;
        int rootPos = 0;
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i) == rootVal) {
                rootPos = i;
                break;
            }
        }
        list.sort((o1, o2) -> o1.intValue()>o2.intValue() ? 1 : o1.intValue() == o2.intValue() ? 0 : -1);
        list.stream().forEach(i -> System.out.println(i));

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<rootPos; i++) {
            stack.push(list.get(i));
        }

        TreeNode node = new TreeNode(list.get(rootPos));
        while (!stack.isEmpty()) {
            add(stack.pop(), node);
        }
        for (int i = rootPos; i<list.size(); i++) {
            stack.push(list.get(i));
        }
        while (!stack.isEmpty()) {
            add(stack.pop(), node);
        }
        System.out.println();
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public void add(int val, TreeNode root) {
        if (root.val == 0)  {
            root.val = val;
            return;
        }

        while (true) {
            if (root.val>val) {
                if (root.left != null)  {
                    root = root.left;
                }
                else  {
                    root.left = new TreeNode(val);
                    return;
                }
            } else {
                if (root.right != null)  {
                    root = root.right;
                } else  {
                    root.right = new TreeNode(val);
                    return;
                }
            }
        }
    }*/
}
