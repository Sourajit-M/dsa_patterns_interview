package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCpuLoad {
    static class Job {
        int start;
        int end;
        int load;
        Job(int start, int end, int load){
            this.start = start;
            this.end = end;
            this.load = load;
        }
        
    }
    public static int findMaxCPULoad(List<Job> jobs){
        int max_load = 0;
        int curr_load = 0;

        Collections.sort(jobs, (a, b) -> a.start -  b.start);

        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> a.end - b.end
        );

        for(Job job : jobs){
            
            while(!pq.isEmpty() && job.start > pq.peek().end){
                Job curr = pq.poll();
                curr_load -= curr.load;
            }

            pq.offer(job);
            curr_load += job.load;
            max_load = Math.max(max_load, curr_load);
        }

        return max_load;
    }
    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(
                new Job(1, 4, 3), 
                new Job(2, 5, 4), 
                new Job(7, 9, 6)
            )
        );

        System.out.println(findMaxCPULoad(input));
    }
}
