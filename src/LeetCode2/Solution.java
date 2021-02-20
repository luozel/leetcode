package LeetCode2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //官方解答 尝试理解
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    //kmp算法 尝试理解
    public int lengthOfLongestSubstring2(String s) {
        int[] arr = new int[128];
        int n = s.length();
        for (int i = 0; i < 128; i++) {
            arr[i] = -1;
        }
        int start = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, arr[index] + 1);
            res = Math.max(res, i - start + 1);
            arr[index] = i;
        }
        return res;
    }
/**
    @Author:         jue
    @Date:     2021/2/20 11:48
 **/
    public int lengthOfLongestSubstring3(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }
        return max;

    }

}

class Test {
    public static void main(String[] args) {
        String str = "basdafgsdbbbfgdfbbb";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2(str));
    }
}