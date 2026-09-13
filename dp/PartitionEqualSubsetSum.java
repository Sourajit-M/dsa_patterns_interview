package dp;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums){
        int n = nums.length;

        int totalsum = 0;

        for(int num : nums)
            totalsum += num;

        if(totalsum % 2 != 0)
            return false;

        int sum = totalsum / 2;

        boolean[][] dp = new boolean[n+1][sum+1];

        //init sum = 0 -> true
        for(int i=0; i<=n; i++)
            dp[i][0] = true;

        for(int i=0; i<n; i++){
            for(int s=1; s<=sum; s++){
                if(nums[i] <= s){
                    dp[i+1][s] = dp[i][s] || dp[i][s - nums[i]];
                }else{
                    dp[i+1][s] = dp[i][s];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
