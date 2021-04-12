package LeetCode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if(rowIndex<0){
            return false;
        }
        return binarySearchRow(matrix[rowIndex],target);
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int row = -1,high = matrix.length-1;
        while (row<high){
            int mid = (high-row+1)/2+row;
            if (matrix[mid][0]<=target){
                row = mid;
            }else {
                high = mid -1;
            }
        }
        return row;
    }
    public boolean binarySearchRow(int[] row, int target) {
        int low = 0,high = row.length-1;
        while (low<=high){
            int mid = (high-low)/2+low;
            if(row[mid]==target){
                return true;
            }else if(row[mid]>target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n=matrix[0].length;
        int low = 0,high = m*n-1;
        while (low<=high){
            int mid = (high-low)/2+low;
            int x= matrix[mid/n][mid%n];
            if(x<target){
                low = mid+1;
            }else if(x>target){
                high =mid-1;
            }else {
                return true;
            }
        }
        return false;
    }
}
