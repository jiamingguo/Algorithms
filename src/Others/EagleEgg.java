package Others;

/**
 * Created by gjm19_000 on 3/21/2017.
 *
 * Here is a N story building and m eggs;
 * We are trying to find out since which floor the egg fell from will break the egg;
 * Question: How many trials it needs to find out ?
 *
 * Tag: Dynamic programming
 */


public class EagleEgg {

    public int solution(int n, int m){
        int [][] dp = new int[n+1][m+1];
        return recur(n, m, dp);
    }

    public int recur(int floor, int egg, int[][] dp){
        if (floor <= 1 || egg ==1){
            return floor;
        }

        int min = floor;

        if (dp[floor][egg] != 0) return dp[floor][egg];

        for(int i=1; i<= floor; i++){
            int upper = recur(floor - i, egg, dp) + 1;
            int lower = recur(i-1, egg - 1, dp) + 1;
            min = Math.min(Math.max(upper, lower),min);
        }

        dp[floor][egg] = min;

        return min;
    }

    public static void main(String args[]){
        EagleEgg test = new EagleEgg();
        System.out.println(test.solution(100,2));
    }
}
