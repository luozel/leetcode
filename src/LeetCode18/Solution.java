package LeetCode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{0,0,0,0}, 0));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if(nums==null&&nums.length<4){
            return lists;
        }
        Arrays.sort(nums);
        for(int i = 0;i<len-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                continue;
            }if(nums[i]+nums[len-3]+nums[len-2]+nums[len-1]<target){
                continue;
            }for (int j = i+1;j<len-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    continue;
                }if (nums[i]+nums[j]+nums[len-2]+nums[len-1]<target){
                    continue;
                }
                int k = j+1;
                int l = len-1;
                while (k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while (k<l&&nums[k]==nums[k+1]){
                            k++;
                        }
                        k++;
                        while (k<l&&nums[l]==nums[l-1]){
                            l--;
                        }
                        l--;
                    }else if(sum<target){
                        k++;
                    }else l--;
                }
            }
        }
        return lists;
    }
}
