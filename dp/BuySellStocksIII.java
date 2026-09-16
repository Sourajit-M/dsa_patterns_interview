package dp;

public class BuySellStocksIII {
    public static int maxProfit(int[] prices){
        int n = prices.length;
        int k = 4;
        int[][] dp = new int[n+1][k+1];

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=k; j++){
                if(j % 2 == 0){
                    dp[i][j] = Math.max(
                        dp[i+1][j-1] - prices[i], dp[i+1][j]
                    );
                }else{
                    dp[i][j] = Math.max(
                        dp[i+1][j-1] + prices[i], dp[i+1][j]
                    );
                }
            }
        }

        return dp[0][k];
    }
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
