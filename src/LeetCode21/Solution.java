package LeetCode21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode listNode1 = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                listNode1.next = l1;
                l1 = l1.next;
            } else {
                listNode1.next = l2;
                l2 = l2.next;
            }
            listNode1 = listNode1.next;
        }
        if (l1 == null) {
            listNode1.next = l2;
        }
        if (l2 == null) {
            listNode1.next = l1;
        }
        return listNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
