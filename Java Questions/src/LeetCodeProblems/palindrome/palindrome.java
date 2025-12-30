package LeetCodeProblems.palindrome;

public class palindrome {
    public static boolean isPalindrome(int x) {
        int abc = x;
        StringBuilder reversedBuilder = new StringBuilder(Integer.toString(x));
        if (reversedBuilder.reverse().toString().equals(Integer.toString(x)))
            return true;
        else return false;
    }

    public static void main(String[] arr){
        System.out.println(isPalindrome(121));
    }
}
