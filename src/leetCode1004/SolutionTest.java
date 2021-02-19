package leetCode1004;

public class SolutionTest {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int num = 2;
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.longestOnes(a,num));
        System.out.println(solution1.longestOnes(a,num));
       System.out.println(Solution.longestOnes(a,num));
        System.out.println(solution2.longestOnes(a,num));
        }
    }
//案例
class Solution {
    public static int longestOnes(int[] A, int K) {
        int l = 0, r = 0, res = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                if (K == 0) {
                    while (A[l] == 1) l++;
                    l++;
                } else {
                    K--;
                }
            }
            res = Math.max(res, ++r - l);
        }
        return res;
    }
    }
    
//动态规划算法
class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[2][k + 1]; // f(i,j) 代表考虑前 i 个数（并以 i 为结尾的），最大翻转次数为 j 时，连续 1 的最大长度
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (nums[i - 1] == 1) {
                    f[i & 1][j] = f[(i - 1) & 1][j] + 1;
                } else {
                    if (j == 0) {
                        f[i & 1][j] = 0;
                    } else {
                        f[i & 1][j] = j - 1 >= 0 ? f[(i - 1) & 1][j - 1] + 1 : 1;
                    }
                }
                ans = Math.max(ans, f[i & 1][j]);
            }
        }
        return ans;
    }
}

class Solution1 {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int res = 0;
        int left = 0,right = 0;
        int count = 0;
        while(right<len){
            if(A[right]==0)
                count++;
            while(count>K) {
                if (A[left++] == 0)
                    count--;
            }
                res = Math.max(right - left + 1, res);
                right++;
            
        }
        return res;
    }
}

//二分查找法 思路分析
class Solution2 {
    public  int longestOnes(int[] A, int K) {
        int n = A.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - A[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - K);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
