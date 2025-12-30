package LeetCodeProblems.LongestPalindromicSubstring;

class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }

        String LPS = "";

        for (int i = 1; i < s.length() ; i++){
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;

                if(low == -1 || high == s.length())
                    break;
            }

            String palindroms = s.substring(low+1, high);

            if(palindroms.length() > LPS.length()){
                LPS = palindroms;
            }

            low = i - 1;
            high = i;
            while(s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;

                if(low == -1 || high == s.length())
                    break;
            }
            palindroms = s.substring(low+1, high);
            if(palindroms.length() > LPS.length()){
                LPS = palindroms;
            }
        }
        return LPS;
    }

    public static void main(String arrgs[]){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}