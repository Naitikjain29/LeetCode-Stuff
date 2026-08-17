class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[i] = earliest index in word1 from which
        // word2[i...] can be matched exactly.
        // n = impossible.
        int[] suf = new int[m + 1];

        suf[m] = n;

        int p = n - 1;

        for (int i = m - 1; i >= 0; i--) {

            while (p >= 0 && word1.charAt(p) != word2.charAt(i)) {
                p--;
            }

            if (p < 0) {
                suf[i] = n;
            } else {
                suf[i] = p;
                p--;
            }
        }

        int[] ans = new int[m];

        int pos = 0;
        boolean usedMismatch = false;

        for (int j = 0; j < m; j++) {

            boolean found = false;

            while (pos < n) {

                // Exact match
                if (word1.charAt(pos) == word2.charAt(j)) {

                    ans[j] = pos;
                    pos++;
                    found = true;

                    break;
                }

                // Use the one allowed mismatch
                boolean remainingPossible =
                    (j + 1 == m) || suf[j + 1] < n;

                if (!usedMismatch &&
                    remainingPossible &&
                    suf[j + 1] > pos) {

                    ans[j] = pos;
                    pos++;
                    usedMismatch = true;
                    found = true;

                    break;
                }

                pos++;
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}