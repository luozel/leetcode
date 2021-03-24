package LeetCode28;

import javax.sound.midi.Soundbank;

public class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int neLen = needle.length();
        if(neLen==0||hayLen==0){
            return 0;
        }
        int itear = 0;
        int n  =hayLen-neLen+1;
        while (itear<n){
            while (itear<n&&haystack.charAt(itear)!=needle.charAt(0)){
                itear++;
            }
                int y =0,count = 0;
           while (itear<hayLen&&y<neLen&&haystack.charAt(itear)==needle.charAt(y)){
                itear++;
                y++;
                count++;
                if(needle.equals(haystack.substring(itear-count,itear))){
                    return itear-count;
                }
            }
           itear = itear-count+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aaa", "aaa"));
//        String s1 = "hello";
//        String s2  = "ll";
//        System.out.println(s2.equals(s1.substring(2, 4)));
    }
}
