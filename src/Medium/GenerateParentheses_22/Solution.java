package Medium.GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjm19_000 on 3/15/2017.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        // back tracking
        List<String> result = new ArrayList<String>();
        recur(n, result, "", 0,0);
        return result;
    }

    public void recur(int max, List<String> result, String current, int open, int close){
        if (current.length()>=max*2){
            result.add(current);
            return;
        }

        if (open<max){
            recur(max,result,current+"(",open+1, close);
        }

        if (close<open){
            recur(max,result,current+")",open, close+1);
        }
    }
}
