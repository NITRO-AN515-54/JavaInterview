import java.util.*;

/* word transformation
   Consider start word as : Dog
   End word as cat
   And words array as [dag,cag,cat]
   You have to find a solution which determines how many transformation required to convert start to end word considering the word is valid only if present in word list
   Also can convert one character at a time */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try changing each character (one at a time)
                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    chars[j] = originalChar; // backtrack
                }
            }

            level++;
        }

        return 0; // no transformation found
    }

    public static void main(String[] args) {
        String start = "dog";
        String end = "cat";
        List<String> wordList = Arrays.asList("dag", "cag", "cat");

        int result = ladderLength(start, end, wordList);
        System.out.println("Minimum transformations required: " + (result == 0 ? "Not possible" : (result - 1)));
    }
}
