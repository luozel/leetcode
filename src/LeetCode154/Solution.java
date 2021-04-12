package LeetCode154;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0,r = nums.length-1;
        int mid = 0;
        while (l<r){
             mid = l+(r-l)/2;
             if(nums[mid]<nums[r]){
                 r = mid;
             }else if(nums[mid]>nums[r]){
                 l = mid+1;
             }else {
                 r--;
             }
        }
        return nums[l];
    }
}
