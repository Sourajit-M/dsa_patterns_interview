package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i < n-1 && end >= intervals[i+1][0]){
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }

            merged.add(new int[]{start, end});
        }

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int intervals[][] = { {1,3}, {2,6}, {8,10}, {15,18} };
        int[][] merge_intervals = merge(intervals);
        
        for (int[] interval : merge_intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
