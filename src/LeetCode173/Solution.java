package LeetCode173;

import java.util.ArrayList;
import java.util.List;

public class Solution {

}

class BSTIterator {

    TreeNode root;
    List<Integer> list = new ArrayList<>();
    int i = 0;

    public BSTIterator(TreeNode root) {
        this.root = root;
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }

    public int next() {
        if (i == list.size() || list.size() == 0) {
            return 0;
        }
        int n = list.get(i);
        i++;
        return n;
    }

    public boolean hasNext() {
        if (i < list.size()) {
            return true;
        }
        return false;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}