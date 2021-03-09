package LeetCode1047;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution1.removeDuplicates("abba"));
    }
}
class  Solution1 {
    public static String removeDuplicates(String S) {
        if(S.length() ==0){
            return "";
        }
        StringBuilder str = new StringBuilder();
        int hrf = -1;
        int len = S.length();
        for (int i = 0;i<len;i++){
            if (hrf>=0&&S.charAt(i)==str.charAt(hrf)){
                str.deleteCharAt(hrf);
                hrf--;
            }else {
                str.append(S.charAt(i));
                hrf++;
            }
        }
        return str.toString();
    }
}
class Solution2 {
    public static String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
