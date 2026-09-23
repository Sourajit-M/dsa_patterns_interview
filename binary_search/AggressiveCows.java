package binary_search;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] arr, int k){
        int n = arr.length;

        Arrays.sort(arr);

        int low = 1, high = arr[n-1]; 
        int res = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canPlace(arr, k, mid)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return res;
    }
    private static boolean canPlace(int[] arr, int k, int dist){
        int count = 1;
        int last_cow = arr[0];

        for(int cow : arr){
            if(cow - last_cow >= dist){
                count++;
                last_cow = cow;
            }
        }

        return count >= k;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(aggressiveCows(arr, k));
    }
}
