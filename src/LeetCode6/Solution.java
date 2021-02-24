package LeetCode6;

import java.util.ArrayList;

public class Solution {
    public String convert(String s,int numRows){
        if (s==null||s.length()==0||numRows<=1) return s;
        StringBuilder[] array = new StringBuilder[numRows];
        for(int i = 0;i<array.length;i++) array[i] = new StringBuilder();
        int dir = 1;
        int index=0;
        for(char c :s.toCharArray()) {
            array[index].append(c);
            index += dir;
            if (index == 0 || index == numRows - 1) dir = -dir;
        }
            StringBuilder result =new StringBuilder();
            for(int i=0;i<array.length;i++) result.append(array[i]);
            return result.toString();
        }

    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert2("PAYPALISHIRING", 3));
    }
}
