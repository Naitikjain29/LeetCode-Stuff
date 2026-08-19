class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store reserved seats as bitmask for each row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Rows without any reservation -> 2 families each
        int count = (n - map.size()) * 2;

        for (int mask : map.values()) {

            // 2,3,4,5
            int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);

            // 4,5,6,7
            int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

            // 6,7,8,9
            int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

            boolean l = (mask & left) == 0;
            boolean m = (mask & middle) == 0;
            boolean r = (mask & right) == 0;

            if (l && r) {
                count += 2;
            } 
            else if (l || m || r) {
                count += 1;
            }
        }

        return count;
    }
}