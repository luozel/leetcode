package LeetCode23;

import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((x,y)->x.val-y.val);
        for(ListNode node : lists){
            if(node!=null){
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!q.isEmpty()){
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null){
                q.add(tail.next);
            }
        }
        return head.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }