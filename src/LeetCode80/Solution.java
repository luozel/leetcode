package LeetCode80;

public class Solution{
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len<2){
            return len;
        }
        int slow =2,fast =2;
        while (fast<len){
            if(nums[slow-2]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    public int removeDuplicates1(int[] nums) {
        int i = 0,len = nums.length;
        int n = 1;
        for (int j = 0; j < len; j++) {
            if(nums[j]==nums[i]&&n<2){
                nums[++i] = nums[j];
                n++;
            }else if(nums[i]!=nums[j]){
                nums[++i] = nums[j];
                n= 1;
            }
        }
        return i+1;
    }
}
