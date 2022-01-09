package y2021.mockassesment;

public class RemoveNthFromEnd {
    public static void main(String... args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l3 = new ListNode();
        l3.val = 3;
        ListNode l4 = new ListNode();
        l4.val = 4;
        ListNode l5 = new ListNode();
        l5.val = 5;

        l1.next= l2;
        /*
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        */
        RemoveNthFromEnd app = new RemoveNthFromEnd();
        app.print(l1);
        ListNode lll = app.removeNthFromEnd(l1, 2);
        app.print(lll);
    }


    void print (ListNode head) {
        ListNode ahead = head;
        while (ahead!=null) {
            System.out.print(ahead.val + " : ");
            ahead = ahead.next;
        }
        System.out.println();
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode ahead = head;
        ListNode prev = head;
        int count = 0;
        while (count<n && ahead!=null) {
            ahead = ahead.next;
            count++;
        }
    if (ahead == null && count == n) return prev.next;
    if (ahead == null) return ahead;
        while (ahead.next!=null) {
            ahead = ahead.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;

    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}