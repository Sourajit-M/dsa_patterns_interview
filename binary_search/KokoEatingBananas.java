package binary_search;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        int res = -1;

        for(int pile : piles){
            high = Math.max(high, pile);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canEat(piles, h, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return res;
    }
    private static boolean canEat(int[] piles, int maxh, int speed){
        int hour = 0;

        for(int pile : piles){
            int time = pile / speed;
            hour += pile % speed == 0 ? time : time + 1; 

            if(hour > maxh)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
