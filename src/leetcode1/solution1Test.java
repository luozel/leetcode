package leetcode1;

import java.util.HashMap;

public class solution1Test {
    public static void main(String[] args) {
        int[] ints = {1,3,5,6,7};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.twoSum(ints,8));
    }
}

class Solution{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
 class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        // // 双重循环 循环极限为(n^2-n)/2 
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j; 
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }
}