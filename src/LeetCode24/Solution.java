package LeetCode24;

import java.util.List;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cur = dumy;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode node = cur.next;
            ListNode l = cur.next.next;
            cur.next = l;
            node.next = l.next;
            l.next  =node;
            cur = node;
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode h = head.next.next;
        h.next = new ListNode(4);
        ListNode listNode = solution.swapPairs(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }