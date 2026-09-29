class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Total length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Start must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int i, int j, int balance) {

        // Balance can never be negative
        if (balance < 0) {
            return false;
        }

        // Out of bounds
        if (i >= grid.length || j >= grid[0].length) {
            return false;
        }

        // Add current character
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid
        if (balance < 0) {
            return false;
        }

        // Destination
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return balance == 0;
        }

        // Already calculated
        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        // Move right or down
        boolean right = dfs(grid, i, j + 1, balance);
        boolean down = dfs(grid, i + 1, j, balance);

        return dp[i][j][balance] = right || down;
    }
}