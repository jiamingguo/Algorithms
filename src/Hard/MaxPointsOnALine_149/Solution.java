package Hard.MaxPointsOnALine_149;

import java.util.HashMap;
import java.math.*;

/**
 * Created by gjm19_000 on 3/1/2017.
 */

public class Solution {


    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;

        int maxNum = 0;

        for (int i=0;i<points.length;i++){
            HashMap<Double, Integer> map = new HashMap<Double,Integer>();
            int samex=1,samePoint=0;

            for (int j=0;j<points.length;j++){
                if (j!=i){

                    if ((points[i].x==points[j].x) && (points[i].y==points[j].y)){
                        samePoint++;
                    }
                    if (points[i].x==points[j].x){
                        samex++;
                        continue;
                    }
                    double slope = (double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);

                    if (map.containsKey(slope)){
                        map.put(slope,(map.get(slope)+1));
                    } else {
                        map.put(slope,2);
                    }

                    maxNum = Math.max(map.get(slope)+samePoint,maxNum);
                }
            }
            maxNum = Math.max(maxNum,samex);
        }

        return maxNum;
    }
}
