package LeetCodeProblems.longestCommonPrefix;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        List<String> list = Arrays.asList(strs);
        String minString = Collections.min(list, Comparator.comparingInt(String::length));
        StringBuilder finalpre = new StringBuilder();;
        int check = 0;
        char prefix;
        for(int i=0;i<minString.length();i++){
            prefix = strs[0].charAt(i);
            for(int j=0;j < strs.length;j++)
            {
                if(prefix == strs[j].charAt(i)){
                    check++;
                }

                if(check == strs.length){
                    finalpre.append(prefix);
                }
            }
            if(strs.length != check)
                break;
            check = 0;
        }
        return finalpre.toString();
    }

    public static String longestCommonPrefixOptimal(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String arrgs[]){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixOptimal(strs));

        String[] strs1 = {"cir","car"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefixOptimal(strs1));
    }
}
