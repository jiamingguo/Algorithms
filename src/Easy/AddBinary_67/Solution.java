package Easy.AddBinary_67;

/**
 * Created by gjm19_000 on 3/12/2017.
 *
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 *
 *
 */
public class Solution {
    public String addBinary(String a, String b) {
        // smart way
        // we do the addition for every bit position. Just like how do add binary by hand
        // Like:
        //          111
        //       +   10
        //      ----'---
        //         1001
        //
        // convert(get mod and append) it to result for each position
        // avoid the overflow problem caused by 'adding in decimal then convert to binary' (since the input string could be damn long

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        String s = "";
        int c=0, aLen= aa.length-1, bLen = bb.length-1;
        while(aLen>=0||bLen>=0||c==1){
            // here is very clever
            // don't need to check who is the longer (shorter) string. Just check if they reach the end every time!
            c+= aLen>=0?aa[aLen--]-'0':0;
            c+= bLen>=0?bb[bLen--]-'0':0;
            char temp = (char)(c%2+'0');
            s = temp+s;
            c /= 2;
        }
        return s;

        // stupid way...
        /*
        int aLen = a.length();
        int bLen = b.length();
        String shortString = aLen>bLen?b:a;
        String longString = aLen>bLen?a:b;
        int shortLen = shortString.length();
        int longLen = longString.length();
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (shortLen>0){
            int atemp = longString.charAt(longLen-1)-'0';
            int btemp = shortString.charAt(shortLen-1)-'0';

            if(atemp==1&&btemp==1){
                if(carry==1){
                    sb.append("1");
                } else{
                    sb.append("0");
                    carry=1;
                }
            }else if(atemp==1^btemp==1){
                if (carry==1){
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else{
                if (carry==1){
                    sb.append("1");
                    carry=0;
                } else{
                    sb.append("0");
                }
            }
            shortLen--;
            longLen--;
        }

        if(carry==1){
            while(longLen>0){
                int atemp = longString.charAt(longLen-1)-'0';
                longLen--;
                if (atemp+carry==2){
                    sb.append("0");
                } else {
                    sb.append("1");
                    carry=0;
                    break;
                }
            }
            if (carry==1){
                sb.append("1");
            }
        }

        for(int i=longLen-1;i>=0;i--){
            sb.append(longString.charAt(i));
        }
        return sb.reverse().toString();
        */

    }
}
