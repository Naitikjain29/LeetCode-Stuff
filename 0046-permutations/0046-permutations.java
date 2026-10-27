class Solution {
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void solve(int[] nums, ArrayList<List<Integer>> ans, int idx){
        if(nums.length == idx){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                temp.add(num);   // convert array → list
            }
            ans.add(new ArrayList<>(temp));       // add copy
            return;
        }

        for(int i = idx; i < nums.length; i++){
            swap(nums, i, idx);
            solve(nums, ans, idx + 1);
            swap(nums, i, idx);  // backtrack
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0);
        return ans;
    }
}