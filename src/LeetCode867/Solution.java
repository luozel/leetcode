package LeetCode867;

import NoTest.Util.IntegerUtil;

public class Solution {
    public int[][] transpose(int[][] matrix) {
        int len = matrix.length;
        int LineLen = matrix[0].length;
        int[][] mar = new int[LineLen][len];
        for(int i=0;i<len;i++){
            for (int j= 0;j<LineLen;j++){
                mar[j][i] = matrix[i][j];
            }
        }
        return mar;
    }

    public int[][] transpose1(int[][] matrix) {
        int[][] target = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                target[i][j] = matrix[j][i];
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a ={{1,2,3},{4,5,6}};
        IntegerUtil.print(a);
    }
}

