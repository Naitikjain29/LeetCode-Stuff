class Solution {
    public long maxAlternatingSum(int[] nums) {
       
        long square[] = new long[nums.length];

        for(int i=0;i<nums.length;i++){
            square[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(square);

        long sum =0;
        for(int i=0;i<nums.length;i++){
            if(i<nums.length/2){
                sum-=square[i];
            }
            else{
                sum+=square[i];
            }
        }

        return sum;

    }
}