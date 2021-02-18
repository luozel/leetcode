package leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class solution1Test {

}

class Solution{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length-1;i++){
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
         HashMap<Integer,Integer> map = new HashMap<>();
         for(int i = 0; i < nums.length; i++){
             if(map.containsKey(nums[i])){
                 return new int[]{map.get(nums[i]), i};
             }
             map.put(target - nums[i], i);
         }
         return null;
     }
}
//参考代码
class Solution3{
    public int[] twoSum(int[] nums,int target) throws IllegalAccessException {
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>(len-1);
        hashMap.put(nums[0],0);
        for (int i=1;i<len;i++){
            //结果为固定值target减去当前的num
            int another = target-nums[i];
            //当找到的时候 返回这个值
            if(hashMap.containsKey(another)){
                return new int[]{i,hashMap.get(another)};
            }
            //放入到hashmap中
            hashMap.put(nums[i],i);
        }
        throw new IllegalAccessException("sorry");
    }
}