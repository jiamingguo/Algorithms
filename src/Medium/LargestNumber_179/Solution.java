package Medium.LargestNumber_179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by gjm19_000 on 3/11/2017.
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 */
public class Solution {
    public String largestNumber(int[] nums) {
        // convert int to string for comparing
        String[] s = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }

        // create comparator
        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String s3 = s1+s2;
                String s4 = s2+s1;
                return s4.compareTo(s3); // reverse order here, so we can do append() later
            }
        }; // rememberthe semi-colon

        // Sort the array
        Arrays.sort(s,comp);

        // here is a cornor case
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s[0].charAt(0)=='0') return "0";

        // append to a buffer
        StringBuffer sb = new StringBuffer();
        for (String ss:s){
            sb.append(ss);
        }

        return sb.toString();
    }
}
