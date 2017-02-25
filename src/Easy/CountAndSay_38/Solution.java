package Easy.CountAndSay_38;

/**
 * Created by gjm19_000
 */
public class Solution {
    public String countAndSay(int n) {
        // starting string is "1"
        String s = "1";

        // loop for the Nth
        for (int i=1;i<n;i++){
            StringBuffer sb = new StringBuffer();
            char[] c = s.toCharArray();

            // scan each char in the string. skip the duplicate.
            int j=0;
            for(;j<c.length;j++){
                char current = c[j];
                int count = 1; // already occurred once

                // if duplicate
                while(j+1<c.length&&current==c[j+1]){
                    count++;
                    j++;
                }
                sb.append(count).append(current);
            }
            s = sb.toString();
        }
        return s;
    }
}
