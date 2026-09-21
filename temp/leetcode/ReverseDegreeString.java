package temp.leetcode;

public class ReverseDegreeString {
    public static int reverseDegree(String s) {
        int res = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int pos = i+1;
            int rev = 26 - (ch-'a');

            res += pos * rev;
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s));
    }
}
