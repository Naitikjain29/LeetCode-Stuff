class Solution {
    public int minimumPushes(String word) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Store frequencies
        List<Integer> list = new ArrayList<>(map.values());

        // Sort in descending order
        Collections.sort(list, Collections.reverseOrder());

        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            int push = (i / 8) + 1;
            ans += list.get(i) * push;
        }

        return ans;
    }
}