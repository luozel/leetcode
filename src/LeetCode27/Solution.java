package LeetCode27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=val){
                nums[num++] = nums[i];
            }
        }
        return num;
    }
    public int removeElement1(int[] nums, int val) {
        int i =0;
        int n = nums.length;
        while (i<n){
            if(nums[i]==val){
                nums[i] = nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(nums, 2));
    }
}
