package LeetCode59;

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n<1){
            return null;
        }
        int[][] ints = new int[n][n];
        int top =0,left = 0,m=1;
        int right = n-1;
        int down = n-1;
        int area = n*n;
        while (m<=area){
            for (int i = left;i<=right;i++) {
                ints[top][i] = m++;
            }
            top++;
            for (int j = top;j<=down;j++) {
                ints[j][right] = m++;
            }
            right--;
            for (int i = right;i>=left;i--) {
                ints[down][i] = m++;
            }
            down--;
            for (int j = down;j>=top;j--) {
                ints[j][left] = m++;
            }
            left++;
        }
        return ints;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateMatrix(3));
    }
}
