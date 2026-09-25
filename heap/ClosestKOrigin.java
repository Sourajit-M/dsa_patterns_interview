package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestKOrigin {
    static class Pair{
        int x;
        int y;
        int dist;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.dist = x*x + y*y;
        }
    }
    public static int[][] kClosest(int[][] points, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.dist, b.dist)
        );

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            pq.offer(new Pair(x, y));
        }

        int[][] res = new int[k][2];

        for(int i = 0; i < k; i++){
            Pair p = pq.poll();

            res[i][0] = p.x;
            res[i][1] = p.y;
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] points = {
            {3,3},{5,-1},{-2,4}
        }; 
        int k = 2;

        int[][] res = kClosest(points, k);

        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
    }
}
