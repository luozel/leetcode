package LeetCode22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    ArrayList[] cache = new ArrayList[100];
   
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String > ans = new ArrayList<>();
        if(n==0){
            ans.add("");
        }else {
            for (int i = 0;i<n;i++){
                for (String left:generate(n)){
                    for (String right :generate(n-1-i)){
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
    
    
    //方式二
    public List<String> generateParenthesis(int n) {
        List<String> ans  = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if(cur.length() == max*2){
            ans.add(cur.toString());
            return;
        }if (open<max){
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }if(close<open){
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
