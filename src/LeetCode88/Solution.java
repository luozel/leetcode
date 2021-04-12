package LeetCode88;

import javax.sound.midi.Soundbank;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int j = 0;
        int l = 0,h=0;
        while (l<m&&h<n){
            if(nums1[l]<nums2[h]){
                temp[j++] = nums1[l++];
            }else {
                temp[j++] = nums2[h++];
            }
        }
        while (l<m)temp[j++]= nums1[l++];
        while (h<n)temp[j++] =nums2[h++];
        for (int i = 0;i<j;i++){
            nums1[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,0,0,0};
        int[]  b= new int[]{2,5,6};
        Solution solution = new Solution();
        solution.merge(a,3,b,3);
    }
    
}
