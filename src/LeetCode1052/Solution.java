package LeetCode1052;

class Solution {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int temp = 0;
        int maxMin = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                temp += customers[i];
            }
        }
        for (int j = 0; j < X; j++) {
            maxMin += customers[j] * grumpy[j];
        }
        int maxNum = maxMin;
        for (int j = X; j < len; j++) {
            maxMin = maxMin - customers[j - X] * grumpy[j - X] + customers[j] * grumpy[j];
            maxNum = Math.max(maxNum, maxMin);
        }
        return temp + maxNum;
    }

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(Solution.maxSatisfied1(customers, grumpy, 3));
    }
    public static int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            maxIncrease = maxIncrease - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            increase = Math.max(increase, maxIncrease);
        }
        return total + increase;
    }

 
}