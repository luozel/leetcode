package LeetCode191;

public class Solution {
    public int hammingWeight(int n) {
        String arr = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0;i<arr.length();i++){
            if (arr.charAt(i)=='1'){
                result++;
            }
        }
        return result;
    }
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            if((n&(1<<i))!=0){
                res++;
            }
        }
        return res;
    }
    public int hammingWeight3(int n) {
        int res = 0;
        while (n!=0){
            n&=n-1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 00000000000000000000000000001011;
        System.out.println(solution.hammingWeight2(n));
    }
}
