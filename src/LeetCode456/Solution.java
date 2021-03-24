package LeetCode456;

import java.util.*;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 2; i < n; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int j = 1; j < n - 1; j++) {
            if (leftMin < nums[j]) {
                Integer next = treeMap.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            treeMap.put(nums[j + 1], treeMap.get(nums[j + 1]) - 1);
            if (treeMap.get(nums[j + 1]) == 0) {
                treeMap.remove(nums[j + 1]);
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidateK = new LinkedList<>();
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        List<Integer> candidateI = new ArrayList<>();
        candidateI.add(nums[0]);
        List<Integer> candidateJ = new ArrayList<>();
        candidateJ.add(nums[0]);
        ArrayList<Object> objects = new ArrayList<>();
        for (int k = 1; k < n; ++k) {
            int idxI = binarySearchFirst(candidateI, nums[k]);
            int idxJ = binarySearchLast(candidateJ, nums[k]);
            if (idxI >= 0 && idxJ >= 0) {
                if (idxI <= idxJ) {
                    return true;
                }
            }
            if (nums[k] < candidateI.get(candidateI.size() - 1)) {
                candidateI.add(nums[k]);
                candidateJ.add(nums[k]);
            } else if (nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                int lastI = candidateI.get(candidateI.size() - 1);
                while (!candidateJ.isEmpty() && nums[k] > candidateJ.get(candidateJ.size() - 1)) {
                    candidateI.remove(candidateJ.size() - 1);
                    candidateJ.remove(candidateJ.size() - 1);
                }
                candidateI.add(lastI);
                candidateJ.add(nums[k]);
            }
        }
        return false;

    }

    private int binarySearchFirst(List<Integer> candidate, int num) {
        int low = 0,high =candidate.size()-1;
        if(candidate.get(high)>=num){
            return -1;
        }
        while (low<high){
            int mid = (high-low)/2+low;
            int num1 = candidate.get(mid);
            if(num1>=num){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public int binarySearchLast(List<Integer> candidate, int target) {
        int low = 0, high = candidate.size() - 1;
        if (candidate.get(low) <= target) {
            return -1;
        }
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            int num = candidate.get(mid);
            if (num <= target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }

    


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n = {-1, 1, 2, 1};
        System.out.println(solution.find132pattern(n));
    }
}
