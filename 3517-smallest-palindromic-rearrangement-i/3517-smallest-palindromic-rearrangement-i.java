import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        char mid = 0;

        // Traverse in lexicographical order
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!map.containsKey(ch)) continue;

            int count = map.get(ch);

            if (count % 2 == 1) {
                mid = ch;
            }

            for (int i = 0; i < count / 2; i++) {
                left.append(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0) {
            ans.append(mid);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}