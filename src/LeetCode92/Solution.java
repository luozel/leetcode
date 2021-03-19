package LeetCode92;

import java.util.List;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode dumpy = pre;
        for (int i = 0; i <left-1 ; i++) {
            dumpy = dumpy.next;
        }
        ListNode rightNode = dumpy;
        for (int i =0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = dumpy.next;
        ListNode cur = rightNode.next;
        dumpy.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);
        dumpy.next = rightNode;
        leftNode.next = cur;
        return pre.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummyNode  = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre  = dummyNode;
        for (int i =0;i<left-1;i++){
            pre  = pre .next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i =left;i<right;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }