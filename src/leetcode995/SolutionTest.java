package leetcode995;

public class SolutionTest {
    public static void main(String[] args) {
    }
}

class Solution1 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + K];
            }
        }
        return ans;
    }
}

class Solution2 {
    public int minKBitFlips(int[] A, int K) {
        int size = A.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (A[i] == 0) {
                if (i + K > size) {
                    return -1;
                } else {
                    for (int j = i; j < i + K; j++) {
                        A[j] ^= 1;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}

class Solution {
    public int minKBitFlips(int[] A, int K) {
        int size = A.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (A[i] == 0) {
                if (i + K > size) {
                    return -1;
                } else {
                    for (int j = i; j < i + K; j++) {
                        A[j] ^= 1;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}