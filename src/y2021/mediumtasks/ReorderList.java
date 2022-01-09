package y2021.mediumtasks;

import y2021.wgeneric.ListNode;

public class ReorderList {

    public static void main(String... args) {
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
        ReorderList  app = new ReorderList();
        app.reorderList(a1);
    }

    public void reorderList(ListNode head) {

        ListNode ln = new ListNode();
        ListNode cur = new ListNode();
        ListNode next = null;

        ListNode sum = null;
        ListNode nn = new ListNode();

        while (head!=null) {
            if (head.next == null) {
                System.out.println(head.val);
                break;
            }
            ln = head;
            sum = new ListNode(head.val);
            sum.next = new ListNode(reorder(ln.next).val);
            cur.next = sum;
            nn = cur;
            reorder3(head);
            head = head.next;
        }


        System.out.println(nn);
    }

    public ListNode reorder(ListNode head) {
        if(head.next == null)
            return head;
        return  reorder(head.next);
    }

    public void reorder3(ListNode head) {
        if(head==null || head.next ==null) {
            return;
        }
        if(head.next.next == null) {
             head.next=null;
             return;
        }
        reorder3(head.next);
    }
}
