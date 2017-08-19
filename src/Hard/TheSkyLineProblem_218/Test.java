package Hard.TheSkyLineProblem_218;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjm19_000 on 7/30/2017.
 */
public class Test {
    public static void main(String[] args) {
        int[][] buildings = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        List<int[]> result = new Solution().getSkyline(buildings);

        System.out.println(result);
    }
}
