package LeetCode115;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinct2(String s, String t) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);
        int pre = 1;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                int temp = dp[j];
                if (j == 0) {
                    dp[j] = 0;
                } else {
                    if (t.charAt(i) == s.charAt(j - 1)) {
                        dp[j] = dp[j - 1] + pre;
                    } else {
                        dp[j] = dp[j - 1];
                    }
                }
                pre = temp;
            }
        }
        return dp[s.length()];
    }

    public int numDistinct3(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }

    public int numDistinct4(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int[] nexts = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = map[c]; j >= 0; j = nexts[j]) {
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }
}
