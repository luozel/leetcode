package LeetCode705;

public class Solution {
    class MyHashSet {
        boolean[] nodes = new boolean[1000009];
        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            nodes[key] = true;
        }

        public void remove(int key) {
            nodes[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return nodes[key];
        }
    }
}
