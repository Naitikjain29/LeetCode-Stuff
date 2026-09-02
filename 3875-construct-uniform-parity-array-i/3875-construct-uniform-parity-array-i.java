class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 0;
        int odd = 0;

        for (int num : nums1) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        // If all elements have same parity
        if (even == nums1.length || odd == nums1.length) {
            return true;
        }

        // If both even and odd exist,
        // we can subtract an opposite-parity number
        // to make every result odd.
        return true;
    }
}