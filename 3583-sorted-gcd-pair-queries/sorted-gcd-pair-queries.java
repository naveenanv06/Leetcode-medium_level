import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }

        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long multiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                multiples += count[j];
            }
        
            long totalPairs = (multiples * (multiples - 1)) / 2;
            
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdCount[j];
            }
            gcdCount[i] = totalPairs;
        }
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + gcdCount[i];
        }       
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefixSum, queries[i]);
        }

        return ans;
    }

    private int binarySearch(long[] prefixSum, long target) {
        int low = 1, high = prefixSum.length - 1;
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] > target) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
