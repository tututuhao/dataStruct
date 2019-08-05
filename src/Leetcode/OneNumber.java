package Leetcode;

import array.Array;

import java.util.TreeMap;



public class OneNumber {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char pre=s.charAt(i);
            char lat=s.charAt(j);
            if (!Character.isLetterOrDigit(pre))
                i++;
            else if (!Character.isLetterOrDigit(lat))
                j--;
            else {
                if (Character.toLowerCase(pre) != Character.toLowerCase(lat))
                    return false;
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


}
