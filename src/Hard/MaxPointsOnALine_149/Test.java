package Hard.MaxPointsOnALine_149;

/**
 * Created by gjm19_000 on 3/1/2017.
 */
public class Test {
    public static void main(String args[]){
        Point[] points = new Point[]{new Point(0,0),new Point(94911151,94911150), new Point(94911152,94911151)};
        Solution s = new Solution();
        int result = s.maxPoints(points);
        System.out.println(result);
    }
}
