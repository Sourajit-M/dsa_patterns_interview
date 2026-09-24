package binary_search;

public class FindMinRotatedSortedArray {
    public static int findMin(int[] nums){
        int low = 0, high = nums.length - 1;
        int res = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                res = mid;
                high = mid - 1;
            }
        }

        return nums[res];
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
