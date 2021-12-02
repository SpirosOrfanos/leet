package easytasks;

import utils.ListNode;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static void main(String... args) {
        AddTwoNumbers app = new AddTwoNumbers();
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(7);
        ListNode ll = app.addTwoNumbers(l1, l2);*/



         ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode ll = app.addTwoNumbers(l1, l2);



        while (ll!=null) {
            System.out.print(ll.val + " ");
            ll = ll.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode nxt = ln;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int cur = 0;
        int val = 0;
        while(l1!=null && l2!=null) {
            val = cur+l1.val+l2.val;
            if (val>=10) {
                cur = 1;
                val = val%10;
            } else {
                cur = 0;
            }
            nxt.next = new ListNode(val);
            nxt = nxt.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 ==null && l2==null && (cur > 0)) {
            nxt.next = new ListNode(cur);
            return ln.next;
        }

        if (l1 ==null && l2==null && (cur == 0)) {
            return ln.next;
        }

        if (l2!=null) {
            while (l2!=null){
                val = cur+l2.val;
                l2 = l2.next;
                if (val>=10) {
                    cur = 1;
                    val = val%10;
                } else {
                    cur = 0;
                }
                nxt.next = new ListNode(val);
                nxt = nxt.next;
            }

        }
        if (l1!=null) {
            while (l1!=null) {
                val = cur+l1.val;
                if (val>=10) {
                    cur = 1;
                    val = val%10;
                } else {
                    cur = 0;
                }
                l1 = l1.next;
                nxt.next = new ListNode(val);
                nxt = nxt.next;
            }

        }
        if ((cur > 0)) {
            nxt.next = new ListNode(cur);
        }
        return ln.next;
    }

}
