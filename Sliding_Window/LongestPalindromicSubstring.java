package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s, List<String> list) {
        if(s.length() <= 1)
            return s;

        String res = ""+s.charAt(0);
        list.add(res);
        int n = s.length();
        for(int i = 1; i < n; i++){
            //odd length palindrome
            int low = i;
            int high = i;

            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }

            String palindrome = s.substring(low+1, high);
            if(palindrome.length() != 0) list.add(palindrome);
            if(res.length() < palindrome.length()){
                res = palindrome;
            }

            //even length palindrome
            low = i-1;
            high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                low--;
                high++;
            }

            palindrome = s.substring(low+1, high);
            if(palindrome.length() != 0) list.add(palindrome);
            if(res.length() < palindrome.length()){
                res = palindrome;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "babad";
        List<String> list = new ArrayList<>();
        System.out.println(longestPalindrome(s, list));
        System.out.println(list);
    }
}
