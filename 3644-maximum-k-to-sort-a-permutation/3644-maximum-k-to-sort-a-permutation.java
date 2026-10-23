class Solution {
    public int sortPermutation(int[] nums) {
        // Initialize with -1 (all bits set to 1 in 2's complement)
        int ans = -1; 
        
        for (int i = 0; i < nums.length; i++) {
            // Track and bitwise-AND all misplaced elements
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        
        // If ans remains -1, the array was already sorted
        return ans == -1 ? 0 : ans;
    }
}
