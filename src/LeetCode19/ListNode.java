package LeetCode19;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        ListNode listNode1 = solution.removeNthFromEnd(listNode, 2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dmmy = new ListNode(0,head);
        int length = getLength(head);
        ListNode cur  =dmmy;
        for (int i = 1;i<length-n+1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dmmy.next;
        return ans;
    }

    private int getLength(ListNode head) {
        int length  = 0;
        while (head!=null){
            ++length;
            head = head.next;
        }
        return length;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dmmy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur  = dmmy;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i =0;i<n;i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dmmy.next;
        return ans;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dmmy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dmmy;
        for (int i =0;i<n;i++){
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next  =second.next.next;
        ListNode ans = dmmy.next;
        return ans;
    }
}