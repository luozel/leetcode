package LeetCode766;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int maxLen = matrix.length;
        int listLen = matrix[0].length;
        for (int i = 1; i < maxLen; i++) {
            for (int j = 1; j < listLen; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {2, 3}, {4, 5}};
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(ints));
    }
}
