package dp;

import java.util.Arrays;

public class Knapsack_01 {
    public static int knapsackMemo(int W, int val[], int wt[]){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(W, val, wt, 0, n, dp);
    }
    private static int solve(int W, int val[], int wt[], int i, int n, int dp[][]){
        if(i == n)
            return 0;

        if(dp[i][W] != -1)
            return dp[i][W];

        if(wt[i] > W)
            return dp[i][W] = solve(W, val, wt, i+1, n, dp);

        //if take the item
        int yes = val[i] + solve(W-wt[i], val, wt, i+1, n, dp);
        //did not take the item
        int no = solve(W, val, wt, i+1, n,dp);

        return dp[i][W] = Math.max(yes, no);
    }

    public static int knapsackTab(int W, int val[], int wt[]){
            int n = val.length;
        int[][] dp = new int[n+1][W+1];
        
        //init W = 0, no capacity
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        
        //init val[i] = 0, empty value item
        for(int w=0; w<=W; w++){
            dp[0][w] = 0;
        }
        
        for(int i=1; i<=n; i++){
            for(int w=1; w<=W; w++){
                //not take the item
                int no = dp[i-1][w];
                
                //take the item 
                int yes = 0;
                
                if(wt[i-1] <= w){
                    yes = val[i-1] + dp[i-1][w - wt[i-1]];
                }
                
                dp[i][w] = Math.max(yes, no);
            }
        }
        
        return dp[n][W];
    }
    public static void main(String[] args) {
        int W = 5;
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};

        long start = System.nanoTime();
        System.out.println(knapsackMemo(W, val, wt));
        long end = System.nanoTime();

        System.out.println("Time taken: " + ((end - start) / 1_000_000.0) + " ms");

        start = System.nanoTime();
        System.out.println(knapsackTab(W, val, wt));
        end = System.nanoTime();

        System.out.println("Time taken: " + ((end - start) / 1_000_000.0) + " ms");
    }
}
