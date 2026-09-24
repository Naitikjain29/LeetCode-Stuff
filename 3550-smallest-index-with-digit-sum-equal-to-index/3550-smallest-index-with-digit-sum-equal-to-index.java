class Solution {
    public int smallestIndex(int[] nums) {
        int ans =-1;
        for(int i=0;i<nums.length;i++){
            if(sum(nums[i]) == i){
                return i;
            }
        }
        return ans;

    }
    public int sum(int n){
        int sumAns =0;
        while(n>0){
            int digit = n%10;
            sumAns+=digit;
            n/=10;

        }
        return sumAns;
    }
}