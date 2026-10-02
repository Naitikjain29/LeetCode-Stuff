class Solution {
    public void solve(int open ,int close,String curr,List<String>ans){
        if(open ==0 && close == 0){
            ans.add(curr);
            return;
        }
        if(open!=0){
            solve(open-1,close,curr +'(',ans);
        }
        if(close>open){
            solve(open,close-1,curr +')',ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans  = new ArrayList<>();
        int open  = n;
        int close = n;

        solve(open,close,"",ans);
        return ans;
    }
}