package LeetCode7;

public class Solution {
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if ((res * 10) / 10 != res) {
                res = 0;
                break;
            }
            int temp = x % 10;
            res = res * 10 + temp;
            x/=10;
        }
        return res;
    }

    public int reverse1(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
