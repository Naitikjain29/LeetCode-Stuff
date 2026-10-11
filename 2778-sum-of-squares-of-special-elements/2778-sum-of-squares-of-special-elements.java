class Solution { 
    public int sumOfSquares(int[] nums) { 
        int n = nums.length; 
        int sum = 0; 
        
        for (int i = 0; i < n; i++) { 
            // Corrected condition: check if n is divisible by the 1-based index (i + 1)
            if (n % (i + 1) == 0) { 
                sum += nums[i] * nums[i]; 
            } 
        } 
        return sum; 
    } 
}
