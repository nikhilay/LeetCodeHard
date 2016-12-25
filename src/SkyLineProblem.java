/**
 * Created by Nikhil on 12/25/16.
 */

import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).The geometric information
 * of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of
 * the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed
 * that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect
 * rectangles grounded on an absolutely flat surface at height 0.
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12],
 * [15 20 10], [19 24 8] ] . The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of
 * a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark
 * the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings
 * should be considered part of the skyline contour. For instance, the skyline in Figure B should be represented
 * as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 */
public class SkyLineProblem {
    public static void main(String[] args) {
        int[][] input ={{0,2,3},{2,5,3}};
        new SkyLineProblem().getSkyline(input);
    }
    class BuildingPoint {
        int x;
        int height;
        boolean isItStart;

        BuildingPoint(int x, int height, boolean isItStart) {
            this.x = x;
            this.height = height;
            this.isItStart = isItStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];
        int index = 0;
        for (int i = 0; i < buildings.length; i++) {
            int startX = buildings[i][0];
            int endX = buildings[i][1];
            int y = buildings[i][2];
            buildingPoints[index++] = new BuildingPoint(startX, y, true);
            buildingPoints[index++] = new BuildingPoint(endX, y, false);
        }

        Arrays.sort(buildingPoints, new Comparator<BuildingPoint>() {
            @Override
            public int compare(BuildingPoint o1, BuildingPoint o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    if (o1.isItStart && o2.isItStart) {
                        return o2.height - o1.height;
                    } else if (!o1.isItStart && !o2.isItStart) {
                        return o1.height- o2.height;
                    } else{
                        return -o2.height - o1.height;
                    }
                }
            }
        });
        for(int i=0;i<buildingPoints.length;i++){
            System.out.println(buildingPoints[i].x +" "+buildingPoints[i].height+" "+buildingPoints[i].isItStart);
        }
        List<int[]> res = new LinkedList<>();
        TreeMap<Integer,Integer> queue = new TreeMap<>();
        int prevMax =0;
        queue.put(0,1);
        int currentMax =0 ;
        for (int i = 0; i < buildingPoints.length; i++) {
            if(buildingPoints[i].isItStart){
                if(queue.containsKey(buildingPoints[i].height)){
                    queue.put(buildingPoints[i].height,queue.get(buildingPoints[i].height)+1);
                }else{
                    queue.put(buildingPoints[i].height,1);
                }
                currentMax = queue.lastKey();
            }else{
                if(queue.get(buildingPoints[i].height)==1){
                    queue.remove(buildingPoints[i].height);
                }else{
                    queue.put(buildingPoints[i].height,queue.get(buildingPoints[i].height)-1);
                }
                currentMax = queue.lastKey();
            }
            if(prevMax!=currentMax){
                res.add(new int[]{buildingPoints[i].x,currentMax});
                prevMax = currentMax;
            }

        }

        return res;
    }
}
