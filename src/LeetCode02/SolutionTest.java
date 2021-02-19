package LeetCode02;

/*
/给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 */
public class SolutionTest {
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dumpy = new ListNode(0);
        ListNode head = dumpy;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            head.next = new ListNode(sum % 10);
            head = head.next;
            addOne = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dumpy.next;
    }

    public static class ListNode {
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

        public static String print(ListNode l) {
            StringBuilder sb = new StringBuilder();
            while (l != null) {
                sb.append(l.val);
                l = l.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(7);
        System.out.println(ListNode.print(addTwoNumbers(l1, l2)));
    }

}