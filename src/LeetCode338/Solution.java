package LeetCode338;

public class Solution {
    public static void main(String[] args) {
        SolutionTest solutionTest = new SolutionTest();
        solutionTest.countBits2(18);
    }
}
class SolutionTest{
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for (int i = 0;i<=num;i++){
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int i) {
        int ones = 0;
        while (i>0){
            i&=(i-1);
            ones++;
        }
        return ones;
    }
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i < num; i++) {
            if((i&(i-1))==0){
                highBit =i;
            }
            bits[i] = bits[i-highBit]+1;
        }
        return bits;
    }
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}