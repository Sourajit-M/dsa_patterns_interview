package two_pointers;

public class BuySellStocksII {
    public static int maxProfitTwoPointers(int[] prices){
        int max_profit = 0;
        int buy = prices[0];

        for(int price : prices){
            if(price > buy){
                max_profit += price - buy;
            }
            buy = price;
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
                        dp[i+1][j+1] + prices[i], dp[i+1][j]
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
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfitTwoPointers(prices));
        System.out.println(maxProfitDP(prices));
    }
}
