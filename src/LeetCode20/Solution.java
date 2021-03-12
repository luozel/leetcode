package LeetCode20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(""));
    }
    public boolean isValid(String s) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        Deque<Object> stack = new LinkedList<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
//        if(n==0){
//            return false;
//        }
        if(n%2==1){
            return false;
        }
        for (int i = 0; i <n ; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if(stack.peek()==map.get(ch)){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
