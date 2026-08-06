class Solution {
    public int smallestNumber(int n, int t) {
          while (true) {
            if (product(n) % t == 0) {
                return n;
            }
            n++;
        }
    }
    public int product(int n){
        int ans =1;
        while(n>0){
            int digit = n%10;
            ans = digit*ans;
            n/=10;
        }
        return ans;
    }
}