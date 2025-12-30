package LeetCodeProblems.StringToInteger;

public class StringToInteger {
    public static int myAtoi(String s) {
        String temp = "";
        boolean digitStarted = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ' && !digitStarted) {
                continue;
            }
            else if (c == '-' && !digitStarted && temp.isEmpty()) {
                temp += c;
            }
            else if (Character.isDigit(c)) {
                temp += c;
                digitStarted = true;
            }
            else {
                break;
            }
        }

        if (temp.isEmpty() || temp.equals("-"))
            return 0;

        try {
            return Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            return temp.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] arrgs){
        System.out.println(myAtoi("+1"));
    }
}
