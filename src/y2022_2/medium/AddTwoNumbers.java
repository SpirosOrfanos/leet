package y2022_2.medium;

import helper.ListNode;

public class AddTwoNumbers {
    public static void main(String... args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        AddTwoNumbers app = new AddTwoNumbers();
        app.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;


        int cur = 0;
        int temp;
        temp = l1.value+l2.value+cur;
        if (temp>=10)  {
            temp-=10;
            cur = 1;
        } else {
            cur = 0;
        }
        ListNode res = new ListNode(temp);
        ListNode resw = res;
        l1 = l1.next;
        l2 = l2.next;
        while (l1!=null && l2!=null) {
            temp = l1.value+l2.value+cur;
            if (temp>=10)  {
                temp-=10;
                cur = 1;
            } else {
                cur = 0;
            }
            res.next = new ListNode(temp);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }

        if (l1 !=null) {
            while (l1!=null) {
                temp = l1.value+cur;
                if (temp>=10)  {
                    temp-=10;
                    cur = 1;
                } else {
                    cur = 0;
                }
                res.next = new ListNode(temp);
                l1 = l1.next;
                res = res.next;
            }
        }

        if (l2!=null) {
            while (l2!=null) {
                temp = l2.value+cur;
                if (temp>=10)  {
                    temp-=10;
                    cur = 1;
                } else {
                    cur = 0;
                }
                res.next = new ListNode(temp);
                l2 = l2.next;
                res = res.next;
            }
        }

        if(cur>0) res.next = new ListNode(cur);
        return resw;
    }
}
