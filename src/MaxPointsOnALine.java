import java.util.HashMap;

/**
 * Created by Nikhil on 12/22/16.
 */

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/24011/accepted-java-solution-easy-to-understand
 */
public class MaxPointsOnALine {
    // Definition for a point.
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hmap = new HashMap<>();
            int samep = 0;
            int samex =1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if(points[j].x==points[i].x && points[j].y==points[i].y){
                        samep++;
                    }

                    if(points[j].x==points[i].x){
                        samex++;
                        continue;
                    }

                    double a =  (double) (points[j].y - points[i].y) /(double) (points[j].x -points[i].x);
                    if(hmap.containsKey(a)){
                        hmap.put(a, hmap.get(a)+1);
                    }else{
                        hmap.put(a,2);
                    }
                    result = Math.max(result, hmap.get(a)+samep);

                }
                result = Math.max(result,samex);
            }
        }
        return result;

    }
}
