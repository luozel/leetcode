package LeetCode34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int firstPot = adjObjectPoint(nums, target, len);
        if (firstPot == -1) {
            return new int[]{-1, -1};
        }
        int lastPot = adjLast(nums, target, len);
        return new int[]{firstPot,lastPot};
    }

    private int adjLast(int[] nums, int target, int len) {
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left+1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

        private int adjObjectPoint ( int[] nums, int target, int len){
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
    }
