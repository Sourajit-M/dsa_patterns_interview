package dp;

// https://www.geeksforgeeks.org/problems/target-sum-1626326450/1
public class TargetSum {
    public static int totalWays(int[] arr, int target){
        // positive sum + negative sum = total sum
        // positive sum - negative sum = target
        // => 2 * positive sum = target + totalsum 
        // => positive sum = (target + totalsum ) / 2
        //so if we can achieve this positive sum with the arrays elements we can reach the target sum

        int n = arr.length;
        int totalsum = 0;

        for(int num : arr)
            totalsum += num;

        if((target + totalsum) % 2 != 0)
            return 0;

        if(totalsum < target)
            return 0;

        int sum = (totalsum + target) / 2;
        int[][] dp = new int[n + 1][sum + 1];

        //init sum = 0 -> one way to reach
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }

        for(int i=0; i<n; i++){
            for(int s=1; s<=sum; s++){
                if(arr[i] <= s){
                    dp[i+1][s] = dp[i][s] + dp[i][s - arr[i]];
                }else{
                    dp[i+1][s] = dp[i][s];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(totalWays(arr, target));
    }
}
