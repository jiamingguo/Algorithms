package Medium.ContainerWithMostWater_11;

/**
 * Created by gjm19_000 on 2/19/2017.
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant (倾斜) the container and n is at least 2.
 *
 *
 * Editorial Solution:
 * https://leetcode.com/articles/container-most-water/
 */

/**
 * 简单的说就是一个算最大面积的two pointer的问题，一左一右，往中间挪动。
 * 在最左边和最右边的时候，j-i，也就是矩形的宽是最大的。每次往中间方向挪动一次pointer，宽都会 -1
 * 所以为了弥补宽的缩短，我们优先挪动下一个height更高的一侧。只有height变高了才可以弥补宽度的减小，才能确保最大（更大）面积
 * 详情请看上面po的editorial solution，有非常明白的解答
 */
public class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0, j=n-1,maxArea=0;
        while(i<j){
            if(height[i]<height[j]){
                maxArea = Math.max(maxArea, height[i]*(j-i));
                i++;
            } else {
                maxArea = Math.max(maxArea, height[j]*(j-i));
                j--;
            }
        }

        return maxArea;
    }
}
