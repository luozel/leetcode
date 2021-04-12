package LeetCode39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if(idx ==candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates,target,ans,combine,idx+1);
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            combine.remove(combine.size()-1);
        }
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{2,3,6,7},7);
    }
}
