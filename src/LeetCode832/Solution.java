package LeetCode832;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A.length;
        for (int n = 0; n < len; n++) {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                if (A[n][left] == A[n][right]) {
                    A[n][left] ^=1;
                    A[n][right] ^=1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[n][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int len = a.length;
        int len1 = a[0].length;
        Solution solution = new Solution();
        int[][] ints = solution.flipAndInvertImage(a);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len1; j++)
                System.out.printf("%5d", ints[i][j]);
            //"%5d"表示按5位的固定位宽输出整型数值。如果不足五位，则在前面补空格；超过五位，则按实际位数输出k
            System.out.println();
        }
    }
}
