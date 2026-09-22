class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(candyType[i],map.getOrDefault(candyType[i],0)+1);
        }
        int ans =0;
        ans = n /2;

        if(ans>map.size()){
            return map.size();
        }
        return ans;

    }
}