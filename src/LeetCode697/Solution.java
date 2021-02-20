package LeetCode697;

import java.util.HashMap;

class SolutionTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 1, 1, 2, 2, 3, 1, 4, 2};
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.findShortestSubArray(a));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(solution.findShortestSubArray2(a));

    }
}
/**
    @Author:         jue
    @Date:     2021/2/20 10:48
 **/
public class Solution {
    public int findShortestSubArray(int[] nums) {
        //res 代表数组的最大长度
        int res = 0;
        int maxNum = 0;
        int right = 0, left = 0;
        int[] temp = new int[50000];
        int len = nums.length;
        int minlen = len;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int maxLength = 0;
            map.put(i, map.getOrDefault(i, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        while (right < len) {
            temp[nums[right]]++;
            if (temp[nums[right]] == res) { //当前值的重复数等于度
                //left指针 移动到 和 right指针 指向 相同值 的位置
                while (nums[left] != nums[right]) {
                    temp[nums[left]]--;  //移动前更新temp数组
                    left++;
                }
                minlen = Math.min(minlen, right - left + 1);
            }
            right++;
        }

        return minlen;
    }

    //计数排序法 尝试理解
    public int findShortestSubArray2(int[] nums) {
        // 找到数组中的最小数和最大数
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        // 使用计数排序的思想
        int[] count = new int[max - min + 1];
        // 记录出现最高的次数是多少次数
        int degree = 0;
        for (int i : nums) {
            degree = Math.max(degree, ++count[i - min]);
        }
        // 如果数组的度为 1，则结果必为 1
        if (degree == 1) {
            return 1;
        }
        int result = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (degree != count[i]) {
                continue;
            }
            // 还原原数的值
            int tmp = min + i;
            // 求该数出现的起始和结束的下标
            int start = 0, end = nums.length - 1;
            while (start < end && tmp != nums[start]) {
                start++;
            }
            while (start < end && tmp != nums[end]) {
                end--;
            }
            result = Math.min(result, end - start + 1);
        }
        return result;
    }

}
