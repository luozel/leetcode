package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;
        int index = 0;
        while (N>0){
            if(index%4==0){
                stack.push(stack.pop()*N);
            }
            else if(index%4==1){
                stack.push(stack.pop()/N);
            }
            else if(index%4==2){
                stack.push(N);
            }else {
                stack.push(-N);
            }
            index++;
            N--;
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
    public int clumsy1(int N) {
        int num[] = {1, 2, 2, -1};
        return N>4?N+num[N%4]:(N>2?N+3:N);
    }
}
