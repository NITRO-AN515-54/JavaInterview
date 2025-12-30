package LeetCodeProblems.reverseInteger;

public class reverseInteger {
    public static int reverse123(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }

        return rev;
    }

    public static void main(String[] args){
        System.out.println(reverse123(-123));
    }
}
