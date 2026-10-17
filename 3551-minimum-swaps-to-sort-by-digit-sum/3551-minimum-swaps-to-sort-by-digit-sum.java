import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // 1. Create pairs of [original value, digit sum]
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = getDigitSum(nums[i]);
        }
        
        // 2. Sort according to the problem constraints:
        //    Primary: Digit sum ascending
        //    Secondary: Value ascending (tiebreaker)
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        // 3. Map each number to its target index in the sorted array
        Map<Integer, Integer> targetPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetPos.put(pairs[i][0], i);
        }
        
        // 4. Use a visited array to find cycles and count swaps
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // Skip if already visited or already in the correct position
            if (visited[i] || targetPos.get(nums[i]) == i) {
                continue;
            }
            
            // Calculate cycle size
            int cycleSize = 0;
            int currentIdx = i;
            
            while (!visited[currentIdx]) {
                visited[currentIdx] = true;
                // Move to the index where the current number belongs
                currentIdx = targetPos.get(nums[currentIdx]);
                cycleSize++;
            }
            
            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    // Helper function to extract digit sum efficiently
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
