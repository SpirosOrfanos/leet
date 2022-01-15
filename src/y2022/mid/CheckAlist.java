package y2022.mid;

import helper.ListNode;

public class CheckAlist {
    public static void main(String... args) {

        ListNode st = new ListNode(100);
        ListNode kp = st;

        for (int i = 0; i<10; i++) {
            kp.next = new ListNode(i);
            kp = kp.next;
        }

        st = st.next;
        while (st!=null) {
        System.out.println(st.value);
        st = st.next;
        }
    }
}
