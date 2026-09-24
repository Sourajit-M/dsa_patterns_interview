package binary_search;

public class SplitLargestSumArray {
    public static int splitArray(int[] nums, int k){
        int res = 0;

        int low = 0, high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canSplit(nums, k, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }
    private static boolean canSplit(int[] nums, int k, int largest){
        int count = 1;
        int sum = 0;

        for(int num : nums){
            if(sum + num > largest){
                count++;
                sum = num;
            }else{
                sum += num;
            }
        }

        return count <= k;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}
