package LeetCode341;

import java.util.*;

public class Solution {
 
}
interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<Integer>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}
 class NestedIterator1 implements Iterator<Integer> {
     private Deque<Iterator<NestedInteger>> stack;
     public NestedIterator1(List<NestedInteger> nestedList){
         stack = new LinkedList<Iterator<NestedInteger>>();
         stack.push(nestedList.iterator());
     } 
     /**
      * Returns {@code true} if the iteration has more elements.
      * (In other words, returns {@code true} if {@link #next} would
      * return an element rather than throwing an exception.)
      *
      * @return {@code true} if the iteration has more elements
      */
     @Override
     public boolean hasNext() {
         while (!stack.isEmpty()){
             Iterator<NestedInteger> it  = stack.peek();
             if(!it.hasNext()){
                 stack.pop();
                 continue;
             }
             NestedInteger nest = it.next();
             if(nest.isInteger()){
                 List<NestedInteger> list = new ArrayList<>();
                 list.add(nest);
                 stack.push(list.iterator());
                 return true;
             }
             stack.push(nest.getList().iterator());
         }
         return false;
     }

     /**
      * Returns the next element in the iteration.
      *
      * @return the next element in the iteration
      * @throws NoSuchElementException if the iteration has no more elements
      */
     @Override
     public Integer next() {
         return stack.peek().next().getInteger();
     }
 }
