package LeetCode82;

import LeetCode1603.solution;

import javax.sound.midi.Soundbank;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        head = dump;
        ListNode left = null, right = null;
        while (dump.next != null) {
            left = dump.next;
            right = left;
            while (right.next != null && right.next.val == left.val) {

                right = right.next;
            }
            if (left != right) {

                dump.next = right.next;
            } else {

                dump = dump.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0,head);
        ListNode cur = dumy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x = cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dumy.next;
    }

    public static void main(String[] args) {
      
        ListNode listNode = new ListNode(1);
         listNode.next = new ListNode(1);
        listNode.next.next= new ListNode(2);
        Solution solution = new Solution();
        System.out.println(solution.deleteDuplicates1(listNode));
    }
}

class ListNode {
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