package two_pointers;

public class BuySellStocksI {
    public static int maxProfitTwoPointers(int[] prices){
        int max_profit = Integer.MIN_VALUE;
        int buy = prices[0];
        int n = prices.length;

        for(int i=1; i<n; i++){
            if(buy > prices[i]){
                buy = prices[i];
            }else{
                int profit = prices[i] - buy;
                max_profit = Math.max(max_profit, profit);
            }
        }
        return max_profit;
    }
    public static int maxProfitDP(int[] prices){
        int n = prices.length;
        int k = 2;

        int[][] dp = new int[n+1][k+1];

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=k; j++){
                if(j == 1){
                    dp[i][j] = Math.max(
                        dp[i+1][j-1] + prices[i], dp[i+1][j]
                    );
                }else{
                    dp[i][j] = Math.max(
                        dp[i+1][j-1] - prices[i], dp[i+1][j]
                    );
                }
            }
        }

        return dp[0][k];
    }
    private static int memo(int[] prices, int n, int i, int k, Integer[][] dp){
        if(i == n || k == 0)
            return 0;

        if(dp[i][k] != null){
            return dp[i][k];
        }

        //buy case
        if(k == 2){
            int c1 = memo(prices, n, i+1, k-1, dp) - prices[i];
            int c2 = memo(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
        //sell case
        else{
            int c1 = memo(prices, n, i+1, k-1, dp) + prices[i];
            int c2 = memo(prices, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfitTwoPointers(prices));
        System.out.println(maxProfitDP(prices));

        Integer[][] dp = new Integer[prices.length + 1][3];
        int ans = memo(prices, prices.length, 0, 2, dp);
        System.out.println(ans);
    }
}
