package Medium.SearchInRotatedSortedArrayII_81;

/**
 * Created by gjm19_000 on 7/2/2017.
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.


 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length == 0)return false;
        // fake binary search
        // when nums[mid] == nums[right], right--; so the total number of equal values will shrink.
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l + 1< r){
            mid = l + (r - l)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[r]){
                if (nums[mid] < target && nums[r] >= target){
                    l = mid;
                }else{
                    r = mid;
                }
            } else if (nums[mid] > nums[r]){
                if (nums[mid] > target && nums[l] <= target){
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                r--;
            }
        }

        if(nums[l] == target || nums[r] == target){
            return true;
        } else {
            return false;
        }
    }
}
