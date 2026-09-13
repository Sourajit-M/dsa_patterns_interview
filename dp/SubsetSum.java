package dp;

// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSum {
    static boolean isSubsetSum(int arr[], int sum){
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];

        //init sum = 0 -> true
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        //init i = 0 -> false no elements
        for(int s=1; s<=sum; s++){
            dp[0][s] = false;
        }

        for(int i=0; i<n; i++){
            for(int s=1; s<=sum; s++){
                //dont include the element
                boolean no = dp[i][s];
                //include the element
                
                boolean yes = false;
                if(arr[i] <= s){
                    yes = dp[i][s - arr[i]];
                }

                dp[i+1][s] = yes || no;
            }
        }

        return dp[n][sum];
    }
    static boolean solve(int[] arr, int sum, int i, Boolean[][] dp){
        if(sum == 0)
            return true;
            
        if(i == 0)
            return false;
            
        if(dp[i][sum] != null)
            return dp[i][sum];
            
        boolean no = solve(arr, sum, i-1, dp);
        
        boolean yes = false;
        
        if(arr[i-1] <= sum){
            yes = solve(arr, sum - arr[i-1], i-1, dp);
        }
        
        return dp[i][sum] = no || yes;
    }
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9;

        System.out.println(isSubsetSum(arr, sum));
    }
}
