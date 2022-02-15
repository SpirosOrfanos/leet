package y2022.asses;

import sun.security.krb5.internal.APOptions;
import y2021.wgeneric.ListNode;

public class ReverseLinkedList2022 {
    public static void main(String... args) {
        ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        ListNode a3 = new ListNode();
        ListNode a4 = new ListNode();
        a1.val = 1;
        a2.val = 2;
        a3.val = 3;
        a4.val = 4;
        a1.next = a2;
        a2.next = a3;
        //a3.next = a4;
        ReverseLinkedList2022 app = new ReverseLinkedList2022();
       app.findMiddle(a1);
        System.out.println();
    }

    public void findMiddle(ListNode ln) {
        ListNode l1 = ln;
        ListNode l2 = ln;
        while (l1!=null && l1.next !=null) {
            l1 = l1.next.next;
            l2 = l2.next;
        }
    System.out.println();
    }
    public ListNode reverse(ListNode head) {
       ListNode curr = head;
       ListNode next = null;
       ListNode prev = null;
       while (curr!=null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
    }
}
