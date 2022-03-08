package y2022_2.medium;

import helper.ListNode;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbersII {
    public static void main(String... args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbersII app = new AddTwoNumbersII();
        app.addTwoNumbers(l1, l2);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        showFrom(l1, q1);
        showFrom(l2, q2);

        int cur = 0;
        int temp;
        ListNode res = new ListNode(0);
        ListNode resw = res;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            temp = q1.poll()+q2.poll()+cur;
            if (temp>=10)  {
                temp-=10;
                cur = 1;
            } else {
                cur = 0;
            }
            res.next = new ListNode(temp);
            res = res.next;
        }

        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                temp = q1.poll()+cur;
                if (temp>=10)  {
                    temp-=10;
                    cur = 1;
                } else {
                    cur = 0;
                }
                res.next = new ListNode(temp);
                res = res.next;
            }
        }
        if (!q2.isEmpty()) {
            while (!q2.isEmpty()) {
                temp = q2.poll()+cur;
                if (temp>=10)  {
                    temp-=10;
                    cur = 1;
                } else {
                    cur = 0;
                }
                res.next = new ListNode(temp);
                res = res.next;
            }
        }
        if(cur>0) res.next = new ListNode(cur);

        return rev(resw.next);
    }

    public void showFrom(ListNode listNode, Queue<Integer> q) {
        if(listNode == null) return;
        showFrom(listNode.next, q);
        q.add(listNode.value);
    }

    public ListNode rev(ListNode listNode) {
        ListNode cu = listNode;
        ListNode next = null;
        ListNode pre = null;
        while (cu!=null) {
            next = cu.next;
            cu.next = pre;
            pre = cu;
            cu = next;
        }
        return pre;
    }

}
