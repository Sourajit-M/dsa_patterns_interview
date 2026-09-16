package dp;

public class BuySellStocksIV {
    public static int maxProfit(int[] prices, int k){
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=2*k; j++){
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

        return dp[0][2*k];
    }
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }
}
