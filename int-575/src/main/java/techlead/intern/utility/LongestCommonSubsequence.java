package techlead.intern.utility;

public class LongestCommonSubsequence {

    public static String longestCommonSubstring(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        int endIndex = 0; // vị trí kết thúc chuỗi con trong chuỗi `a`

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i; // cập nhật vị trí kết thúc mới
                    }
                }
            }
        }

        return a.substring(endIndex - maxLen, endIndex); // trích xuất chuỗi con
    }

    public static String longestCommonSubstringWithKLength(String a, String b, int k) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        int endIndex = 0; // vị trí kết thúc chuỗi con trong chuỗi `a`

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i; // cập nhật vị trí kết thúc mới
                    }
                }
            }
        }

        String result = a.substring(endIndex - maxLen, endIndex);
        if (k > result.length()) {
            return null;
        }

        return result;
    }

    public static void main(String[] args) {
        String result = longestCommonSubstring("abcdef", "abczyzcdef");
        System.out.println("Chuỗi con chung dài nhất: " + result);
    }
}
