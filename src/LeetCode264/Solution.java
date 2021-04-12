package LeetCode264;

import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int l = 1, num = 1,right=1;
        while (num < n) {
            l=right+1;
            right++;
            while (l % 2 == 0) l /= 2;
            while (l % 3 == 0) l /= 3;
            while (l % 5 == 0) l /= 5;
            if(l==1){
                num++;
            }
        }
        return right;
    }

    public int nthUglyNumber1(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber1(10));
    }
}
