package LeetCode303;

public class Solution {
}
class NumArray {
   int sum[];

    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len+1];
        for(int i=0;i<len;i++){
            sum[i+1] = sum[i] +nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}