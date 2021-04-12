package LeetCode781;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int y :answers){
            map.put(y, map.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
            
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numRabbits(new int[]{1,1,2});
    }
}
