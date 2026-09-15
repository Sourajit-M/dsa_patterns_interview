package dp;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequenceMemo(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        Integer[][] dp = new Integer[m+1][n+1];

        return memo(text1, text2, 0, 0, dp);
    }
    private static int memo(String s1, String s2, int i, int j, Integer[][] dp){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }

        if(dp[i][j] != null)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = memo(s1, s2, i+1, j+1, dp) + 1;
        }else{
            int c1 = memo(s1, s2, i+1, j, dp);
            int c2 = memo(s1, s2, i, j+1, dp);
            return dp[i][j] = Math.max(c1, c2);
        }
    }

    public static int longestCommonSubsequenceTab(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(
                        dp[i+1][j], dp[i][j+1]
                    );
                }
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequenceMemo(text1, text2));

        System.out.println(longestCommonSubsequenceTab(text1, text2));
    }
}
