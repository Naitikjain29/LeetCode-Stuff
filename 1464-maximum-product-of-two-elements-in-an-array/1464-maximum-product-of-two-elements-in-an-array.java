class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer(num);
        }

        int first = pq.poll();
        int second = pq.poll();

        return (first - 1) * (second - 1);
    }
}