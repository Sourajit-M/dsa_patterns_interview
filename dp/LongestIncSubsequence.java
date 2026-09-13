package dp;

public class LongestIncSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length+1];
        return solve(nums, 0, -1, dp);
    }
    static int solve(int[] nums, int i, int prev, int[] dp){
        if(i == nums.length)
            return 0;

        if(dp[i] != 1){
            return dp[i];
        }

        int no = solve(nums, i+1, prev, dp);
        int yes = 0;
        if(prev == -1 || nums[i] > nums[i-1])
            yes = 1 + solve(nums, i+1, i, dp);

        return dp[i] = Math.max(yes, no);
    }
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
