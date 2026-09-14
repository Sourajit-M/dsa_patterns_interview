package dp;

import java.util.Arrays;

public class LongestIncSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return memoization(nums, 0, -1, dp);
    }
    static int recursion_method(int[] nums, int i, int prev){
        if(i == nums.length)
            return 0;

        if(prev == -1 || nums[i] > nums[prev]){
            return Math.max(1 + recursion_method(nums, i+1, i), recursion_method(nums, i+1, prev));
        }else{
            return recursion_method(nums, i+1, prev);
        }
    }

    static int memoization(int nums[], int i, int prev, int[][] dp){
        if(i == nums.length)
            return 0;

        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }

        if(prev == -1 || nums[i] > nums[prev]){
            return dp[i][prev+1] = Math.max(
                1 + memoization(nums, i+1, i, dp), memoization(nums, i+1, prev, dp)
            );
        }else{
            return dp[i][prev+1] = memoization(nums, i+1, prev, dp);
        }
    }

    static int tabulation(int nums[]){
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        dp[0] = 0;

        int res = 1;

        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] > nums[j]){
                    dp[i+1] = Math.max(dp[i+1], 1 + dp[j+1]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
    static int bin_search_approach(int[] nums){
        int[] temp = new int[nums.length + 1];
        int len = 1;

        temp[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] > temp[len - 1]){
                temp[len] = nums[i];
                len++;
            }else{
                int idx = lower_bound(temp, 0, len-1, nums[i]);
                temp[idx] = nums[i];
            }
        }

        return len;
    }

    private static int lower_bound(int[] nums, int low, int high, int target){
        int res = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target > nums[mid]){
                low = mid + 1;
            }else{
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

        System.out.println("####### Tabulation ######");
        System.out.println(tabulation(nums));

        System.out.println("####### Binary Search ######");
        System.out.println(bin_search_approach(nums));
    }
}
