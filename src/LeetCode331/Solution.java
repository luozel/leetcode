package LeetCode331;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValidSerialization1("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
    public boolean isValidSerialization1(String preorder) {
        int n = preorder.length();
        int i = 0;
        int solts = 1;
        while (i < n) {
            if (solts == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                solts--;
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                solts++;
            }
        }
        return solts == 0;
    }

    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
