package LeetCode153;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0,r = nums.length-1;
        while (l<r) {
              int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1; 
            }
        }
        return nums[l];
    }
    public int findMin1(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i]<nums[0]){
                return nums[i];
            }
        }
        return nums[0];
    }
}
