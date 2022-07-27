package y2022_3.easy;

import y2022_3.util.NodeListItem;

import java.math.BigDecimal;

public class InsertINtoLinkedList {
    public static void main(String... args) {
        BigDecimal b = new BigDecimal("0.00");
    System.out.println(b.compareTo(new BigDecimal(0)));
        /* InsertINtoLinkedList app = new InsertINtoLinkedList();
        NodeListItem l = app.createCycleLinkedList();
        app.findNodePosition(l, 5);
        System.out.println();*/
    }



    private void findNodePosition(NodeListItem nodeListItem, int val) {
        NodeListItem prev = nodeListItem;
        NodeListItem next = nodeListItem.next;
        while (true) {
            int prevVal = prev.val;
            int nextVal = next.val;
            boolean isBetween = (prevVal<=val && nextVal>=val);
            boolean insertAsStart = (prevVal>=val && nextVal>=val && prevVal>nextVal);
            boolean insertAsEnd = (prevVal<=val && nextVal<=val && prevVal>nextVal);
            if (isBetween ||
                    insertAsStart ||
                    insertAsEnd) {
                NodeListItem nn = new NodeListItem();
                nn.val = val;

                nn.next = prev.next;
                prev.next = nn;

                break;
            }


            prev = prev.next;
            next = next.next;
        }
    }

    public NodeListItem createCycleLinkedList() {
        NodeListItem nodeListItem1 = new NodeListItem();
        nodeListItem1.val = 4;

        NodeListItem nodeListItem2 = new NodeListItem();
        nodeListItem2.val = 6;

        NodeListItem nodeListItem3 = new NodeListItem();
        nodeListItem3.val = 8;

        NodeListItem nodeListItem4 = new NodeListItem();
        nodeListItem4.val = 10;

        nodeListItem1.next = nodeListItem2;
        nodeListItem2.next = nodeListItem3;
        nodeListItem3.next = nodeListItem4;
        nodeListItem4.next = nodeListItem1;


        return nodeListItem3;
    }

    public NodeListItem createLinkedList() {
        NodeListItem nodeListItem1 = new NodeListItem();
        nodeListItem1.val = 4;

        NodeListItem nodeListItem2 = new NodeListItem();
        nodeListItem2.val = 6;

        NodeListItem nodeListItem3 = new NodeListItem();
        nodeListItem3.val = 8;

        NodeListItem nodeListItem4 = new NodeListItem();
        nodeListItem4.val = 10;

        nodeListItem1.next = nodeListItem2;
        nodeListItem2.next = nodeListItem3;
        nodeListItem3.next = nodeListItem4;

        return nodeListItem3;
    }
}
