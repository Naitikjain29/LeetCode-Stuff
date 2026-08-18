class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // If k == n, whole array is only one subarray
        if (k == n) {
            int ans = -1;
            for (int x : nums) {
                ans = Math.max(ans, x);
            }
            return ans;
        }

        int ans = -1;

        // First element appears in only first window
        ans = Math.max(ans, nums[0]);

        // Last element appears in only last window
        ans = Math.max(ans, nums[n - 1]);

        // But if same element occurs multiple times,
        // it may appear in more than one window.
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
        }

        // Simple correct approach
        java.util.HashMap<Integer, Integer> count = new java.util.HashMap<>();

        for (int i = 0; i <= n - k; i++) {
            java.util.HashSet<Integer> window = new java.util.HashSet<>();

            for (int j = i; j < i + k; j++) {
                window.add(nums[j]);
            }

            for (int x : window) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        ans = -1;

        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}