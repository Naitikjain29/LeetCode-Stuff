class Solution {

    int ans = 0;

    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        int subtreeMax = Math.max(root.val, Math.max(leftMax, rightMax));

        if (root.val == subtreeMax)
            ans++;

        return subtreeMax;
    }
}