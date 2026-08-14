class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = s.length();
        int ans = 0;

        while (j < n) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) < 3) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } 
            else {
                while (map.get(ch) > 2) {
                    char c = s.charAt(i);

                    map.put(c, map.getOrDefault(c, 0) - 1);

                    i++;
                }

                ans = Math.max(ans, j - i + 1);
                j++;
            }
        }

        return ans;
    }
}