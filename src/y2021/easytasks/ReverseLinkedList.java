package y2021.easytasks;

import y2021.wgeneric.ListNode;

import java.util.*;

public class ReverseLinkedList {

    public static void main(String... args) {
        /*ListNode a1 = new ListNode();
        ListNode a2 = new ListNode();
        ListNode a3 = new ListNode();
        ListNode a4 = new ListNode();
        a1.val = 1;
        a2.val = 2;
        a3.val = 3;
        a4.val = 4;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ReverseLinkedList app = new ReverseLinkedList();

        ListNode a = app.reverse(a1);
        System.out.println();*/
        ReverseLinkedList app = new ReverseLinkedList();
        /*System.out.println(app.calculate("3*2*2+5"));
        System.out.println(app.calculate("3+2*2+5"));
        System.out.println(app.calculate("3+2+8+5"));
        System.out.println(app.calculate("7+2+2*5"));
        System.out.println(app.calculate("5+2*2*9+3*3*3"));
        System.out.println(app.calculate("2*2*2*5"));*/
        System.out.println(app.calculate("14/3*2"));

    }

    public int calculate(String s) {
        int res = 0;
        s= s.trim();
        Set<Character> basicTypes = new HashSet<>();
        basicTypes.add('+');
        basicTypes.add('-');
        basicTypes.add('/');
        basicTypes.add('*');

        Set<Character> types = new HashSet<>();
        types.add('/');
        types.add('*');
        Deque<Integer> stack = new LinkedList<>();
        Queue<Integer> comp = new LinkedList();


        StringBuilder sb = new StringBuilder();
        boolean lastM = false;
        for (char c:s.toCharArray()) {
            if (c == ' ') continue;;
            if(basicTypes.contains(c)) {

                int jj = (Integer.parseInt(sb.toString()));
                stack.add(lastM ? -jj: jj);
                sb = new StringBuilder();
                if (c == '+') comp.add(1);
                if (c == '-') comp.add(2);
                if (c == '*') comp.add(3);
                if (c == '/') comp.add(4);
                if (c == '-') lastM = true;
                else lastM = false;


            } else {
                sb.append(c);
            }
        }

        stack.add(lastM ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString()));
        List<Integer> ff = new ArrayList<>();
        int rem = 1;
        while (!comp.isEmpty()) {
            int sc = comp.peek();
            if (sc ==  1) {
                comp.poll();
                ff.add(stack.poll());
                rem = 1;
            }
            else if (sc == 2) {
                comp.poll();
                ff.add(stack.poll());
                rem = 1;
            } else {

                boolean first = false;
                while (!comp.isEmpty() && comp.peek()!=1 && comp.peek()!=2) {
                    int tt = comp.peek();
                    if (tt == 3) {
                        if (!first) rem=stack.poll()* stack.poll();
                        else rem = rem*stack.poll();
                    } else {
                        if (!first) rem=stack.poll() / stack.poll();
                        else rem = rem/stack.poll();
                    }
                    comp.poll();
                    first = true;
                }
                stack.addFirst(rem);
            }


        }

        while(!stack.isEmpty()) {
            ff.add(stack.poll());
        }
        for (int i :ff) res+=i;
        return res;
    }

    public ListNode reverse(ListNode head) {

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
