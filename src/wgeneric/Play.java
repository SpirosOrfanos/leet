package wgeneric;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Play {
    public static void main(String... args) {
        /*Stack<Integer> stack = new Stack<>();

        stack.add((1));
        stack.add((2));
        stack.add((3));
        stack.add((4));

        ListNode cur = new ListNode(stack.pop());
        ListNode next = null;
        ListNode prev = null;
        while (!stack.isEmpty()) {
            next = new ListNode(stack.pop());
            next.next = cur;
            cur = next;

        }*/
        ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        ListNode a3 = new ListNode();
        ListNode a4 = new ListNode();
        ListNode a5 = new ListNode();
        a1.val = 1;
        a2.val = 2;
        a3.val = 3;
        a4.val = 4;
        a5.val = 5;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        Play app = new Play();
        app.reverseKGroup(a1, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<2) return head;
        Queue<ListNode> q = new LinkedList();
        Stack<ListNode> s = new Stack<>();
        Stack<ListNode> temp = new Stack<>();
        Stack<ListNode> all = new Stack<>();
        int n = 0;

        while (head!=null) {
            n=k;
            while (n>0 && head!=null) {
                q.add(head);
                head = head.next;
                n--;
            }
            if (n>0) {
                while (!q.isEmpty()) all.push(q.poll());
                break;
            }
            while (!q.isEmpty()) s.push(q.poll());
            while (!s.isEmpty()) all.add(s.pop());

        }

        ListNode cur = new ListNode(all.pop().val);
        ListNode next;
        while (!all.isEmpty()) {
            next = new ListNode(all.pop().val);
            next.next = cur;
            cur = next;
        }
        return cur;
    }

}

