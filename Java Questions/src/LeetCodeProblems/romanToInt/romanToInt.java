package LeetCodeProblems.romanToInt;

/*

Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.

 */

import java.util.HashMap;

public class romanToInt {
    public static int romanToInt(String s) {

        HashMap<Character,Integer> temp  =  new HashMap<Character, Integer>();
        temp.put('I',1);
        temp.put('V',5);
        temp.put('X',10);
        temp.put('L',50);
        temp.put('C',100);
        temp.put('D',500);
        temp.put('M',1000);

        int total = temp.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            int curr = temp.get(s.charAt(i));

            if (curr < temp.get(s.charAt(i + 1))) {
                total -=  curr;
            } else {
                total += curr;
            }
        }

        return total;
    }

    public static void main(String[] arrgs){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
