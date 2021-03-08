package LeetCode232;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
}

class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.isEmpty()){
            intoout();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            intoout();
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
    private void intoout() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
    
}