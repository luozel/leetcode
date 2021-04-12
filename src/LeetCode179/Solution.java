package LeetCode179;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int proint = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (proint >= y) {
                y *= 10;
            }
            if (nums[i] * y + proint > nums[i] + proint * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
    public String largestNumber2(int[] nums) {
        int n  =nums.length;
        Integer[] number = new Integer[n];
        for (int i = 0; i < n; i++) {
            number[i]  = nums[i];
        }
        Arrays.sort(number,(x,y)->{
            long sx = 10,sy = 10;
            while (sx<=x){
                sx *=10;
            }while (sy<=y){
                sy *=10;
            }
            return (int)(sx*y+x-sy*x-y);
        });
        if(number[0]==0){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int num : number) {
            builder.append(num);
        }
        return builder.toString();
    }
}
