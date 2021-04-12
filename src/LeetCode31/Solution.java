package LeetCode31;

import javax.sound.midi.Soundbank;

public class Solution {
    public int[] nextPermutation(int[] nums) {
        int len = nums.length-2;
        while (len>=0&&nums[len]>=nums[len+1]){
            len--;
        }
        if(len>=0){
            int j = nums.length - 1;
            while (j>=0&&nums[len]>=nums[j]){
                j--;
            }
            swap(nums,len,j);
        }
        reverse(nums,len+1);
        return nums;
    }

    private void reverse(int[] nums, int i) {
        int left = i,right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int len, int j) {
        int temp = nums[j];
        nums[j] = nums[len];
        nums[len] = temp;
    }

    public static void main(String[] args) {
        int[] n ={1,2,3,8,5,7,6,4};
        Solution solution = new Solution();
        int[] ints = solution.nextPermutation(n);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
