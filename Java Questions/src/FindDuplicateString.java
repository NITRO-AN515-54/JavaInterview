/*

Write program that will tell how many time a words come and print those who are duplicate

*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateString {
    public static void main (String arrgs[]){
        String abc = "This is my Life and this lifE is good";
        System.out.println(abc);

        String sentence = "Java streams are powerful for data processing, and Java streams are great for finding duplicates.";

        // Clean the sentence and split into a list of words
        List<String> words = Arrays.asList(sentence.toLowerCase().split(" "));

        // Find duplicate words using groupingBy and filtering
        Set<String> duplicateWords = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group words by count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Filter entries where count > 1
                .map(Map.Entry::getKey) // Map to get the actual word (key)
                .collect(Collectors.toSet()); // Collect the duplicate words into a Set

        System.out.println("Original sentence: " + sentence);
        System.out.println("Duplicate words: " + duplicateWords);
    }
}
