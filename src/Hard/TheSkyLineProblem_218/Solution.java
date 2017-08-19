package Hard.TheSkyLineProblem_218;


import java.util.*;

/**
 * Created by gjm19_000 on 7/30/2017.
 */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // https://briangordon.github.io/2014/08/the-skyline-problem.html
        List<int[]> result = new ArrayList<int[]>();

        // step 1, find critical points
        // create array to store critical points (index, height).
        List<int[]> height = new ArrayList<int[]>();

        for (int[] rect : buildings) {
            // if height is negative number, then it means it is the start of rectangle
            // else, if it is positive number, then it is the end of that rectangle.
            height.add(new int[]{rect[0], -rect[2]});
            height.add(new int[]{rect[1], rect[2]});
        }

        // step 2, sort critical points.
        // lambda expression for Comparator
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]){
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // step 3, create Heap to store 'Active Set'
        // Active Set at a particular index is the acive rectangles that cover that index.
        // We use this to store the height of rectangles at a particular index. In order to find the highest value.
        // Create with Lambda Comparator. We want to reach the highest value. So it's a Max Heap.
        PriorityQueue<Integer> activeSet = new PriorityQueue<Integer>((a, b)->(b-a));

        // step 4, traverse buildings. Generate skyline.
        // use prev to avoid duplicate values: i.e. two rectangles have same height, there should be one critical point. Not two.
        // activeSet.offer(0);
        int prev = 0;
        int cur = 0;
        activeSet.add(0);
        for (int[] point : height) {
            // if it is the end of a building
            if (point[1] > 0) {
                activeSet.remove(point[1]);
            } else {
                activeSet.offer(-point[1]);
            }

            cur = activeSet.peek();
            System.out.println(cur);

            if (cur != prev) {
                result.add(new int[]{point[0], cur});
                prev = cur;
            }
        }

        return result;

    }

    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
