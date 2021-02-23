package LeetCode5;

class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 1;
        int begin = 0;
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            int aLong = BackLong(s, i, i + 1);
            int aLong2 = BackLong(s, i, i);
            int len = Math.max(aLong, aLong2);
            if (len > maxlen) {
                maxlen =len;
                begin = i -(maxlen-1) / 2;
            }
        }

        return s.substring(begin, begin+maxlen);
    }

    private int BackLong(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public String longestPalindrome1(String s) {
        int len = s.length();
        if(len <2){
            return s;
        }
        int maxlen = 1;
        int begin = 0;
        char[] charrArray = s.toCharArray();
        for(int i = 0;i<len-1;i++){
            //枚举大于等于2的范围
            for(int j =i+1;j<len ;j++){
                if(j-i+1>maxlen&&valiPalindromic(charrArray,i,j)){
                    maxlen=j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
    private boolean valiPalindromic(char[] charArray,int left,int right){
        while (left<right){
            if (charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    //动态规划解法:
    public String longestPalindrome2(String s){
        int len = s.length();
        if(len<2){
            return s;
        }
        int maxLen =1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i<len ;i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for(int j = 1;j<len;j++){
            for (int i = 0;j<j;i++){
                if(charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                //只要dp[i][j] ==true 成立 就表示子串是s[i..j]是回文
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    
    //Manacher算法
    //(预处理字符串的回文子串长度-1)/2  = 原始字符串的回文子串长度=以i为中心点向两边能扩散的步数
}