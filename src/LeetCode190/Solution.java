package LeetCode190;

public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for(int i =0;i<32&&n!=0;++i){
            rev |=(n&1)<<(31-i);
            n>>>=1;
        }
        return rev;
    }
}
