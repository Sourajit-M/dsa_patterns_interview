package dp;

import java.util.Arrays;

public class MinCostCutStick {
    public static int minCostMemo(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;

        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;

        for(int i=0; i<m; i++)
            arr[i+1] = cuts[i];

        Integer[][] dp = new Integer[m+1][m+1];

        return memo(n, arr, 1, m, dp);
    }
    private static int memo(int n, int[] cuts, int i, int j, Integer[][] dp){
        if(i > j)
            return 0;

        if(dp[i][j] != null)
            return dp[i][j];

        int res = Integer.MAX_VALUE;

        for(int k=i; k<=j; k++){
            int cost = cuts[j+1] - cuts[i-1];
            int r = cost + memo(n, cuts, i, k-1, dp) + memo(n, cuts, k+1, j, dp);
            res = Math.min(res, r); 
        }

        return dp[i][j] = res;
    }
    public static int minCostTab(int n, int[] cuts){
        int m = cuts.length;
        Arrays.sort(cuts);

        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;

        for(int i=0; i<m; i++)
            arr[i+1] = cuts[i];

        int[][] dp = new int[m+1][m+1];

        for(int i=m; i>=1; i--){
        for(int j=i; j<=m; j++){
            int res = Integer.MAX_VALUE;
            for(int k=i; k<=j; k++){
                int cost = arr[j+1] - arr[i-1];
                int r = cost + dp[i][k-1] + dp[k+1][j];
                res = Math.min(res, r);
            }

            dp[i][j] = res;
        }
    }

    return dp[1][m];
    }
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        int n = 7;

        System.out.println(minCostMemo(n, cuts));
        System.out.println(minCostTab(n, cuts));
    }
}
