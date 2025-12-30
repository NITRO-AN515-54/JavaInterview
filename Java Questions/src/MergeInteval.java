/*

Merge the interval for the 2D array and create new range for the list

int [][] a = {{-3,-1}, {1,3}, {4,6}, {16,92}};
int [] newInterval = {2,10};

After merging new range => {{-3,-1}, {1,10}, {16,92}}

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInteval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // 1. Add all intervals that end before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{-3,-1}, {1,3}, {4,6}, {16,92}};
        int[] newInterval = {2,10};

        int[][] merged = insert(a, newInterval);

        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
