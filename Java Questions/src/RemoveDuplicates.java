import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "Happynewyear";
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        System.out.println(set); // Order can be random
    }
}
