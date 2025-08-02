/* Divide candies among the children having rating as provided in inputA= [1,2,3,2,1]
   The candies distribution should follow below condition
   (i) Children with higher rating must be getting more candies then their neighbours
   (ii) All children must get atleast one candies */

import java.util.Arrays;

public class CandyDistribution {
    public static int[] distributeCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Step 1: give every child at least 1 candy

        // Step 2: Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return candies;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 3, 2, 1};
        int[] result = distributeCandies(ratings);

        System.out.println("Candy Distribution: " + Arrays.toString(result));

        int totalCandies = 0;
        for (int candy : result) {
            totalCandies += candy;
        }
        System.out.println("Total Candies: " + totalCandies);
    }
}