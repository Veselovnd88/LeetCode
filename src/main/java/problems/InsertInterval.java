package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author VeselovND <br>
 * created at 20.06.2024 <br>
 * <a href="https://leetcode.com/problems/insert-interval/">Insert interval</a>
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals1 = new int[][]{{1, 3}, {5, 9}};
        int[] newInterval = new int[]{2, 5};
        // System.out.println(Arrays.deepToString(insert(intervals1, newInterval)));

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = new int[]{4, 8};
        //   System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));

        int[][] intervals3 = new int[][]{{1, 5}};
        int[] newInterval3 = new int[]{2, 3};

        System.out.println(Arrays.deepToString(insert(intervals3, newInterval3)));

        int[][] intervals4 = new int[][]{{1, 5}};
        int[] newInterval4 = new int[]{5, 7};

        // System.out.println(Arrays.deepToString(insert(intervals4, newInterval4)));

        int[][] intervals5 = new int[][]{{1, 5}};
        int[] newInterval5 = new int[]{6, 8};

        //System.out.println(Arrays.deepToString(insert(intervals5, newInterval5)));

        int[][] intervals6 = new int[][]{{1, 5}};
        int[] newInterval6 = new int[]{6, 8};

        //System.out.println(Arrays.deepToString(insert(intervals5, newInterval5)));


    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        if (intervals.length == 0) {
            int[][] ints = new int[1][2];
            ints[0] = newInterval;
            return ints;
        }
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }


        int start = newInterval[0];
        int end = newInterval[1];

        int left = 0;
        int right = ends.length;

        if (intervals.length > 1) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (start < ends[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        //нахожу индекс интервала, который заканчивается числом БОЛЬШИМ чем начало нового интервала
        System.out.println("LEFT " + left);

        System.out.println(Arrays.toString(ends));

        //копируем всё до начала внесения нового интервала
        List<int[]> fresh = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            fresh.add(intervals[i]);
        }
        boolean isMerged = false;
        if (intervals[left][1] < end && intervals[left][1] > start) {
            intervals[left][1] = end;
            isMerged = true;
        } // продлили найденный интервал до конца нового интервала
        fresh.add(intervals[left]);

        for (int i = left; i < intervals.length; i++) {
            //теперь нужно проверить начала следующих интервалов, если оно меньше чем конец - то меняем
            if (intervals[i][0] < end && intervals[i][1] < end) {
                continue;
            }
            if (intervals[i][0] <= end) {
                intervals[left][1] = intervals[i][1];
                isMerged = true;
                continue;
            }
            fresh.add(intervals[i]);
        }
        if (!isMerged) {
            fresh.add(newInterval);
        }
        int[][] newArray = new int[fresh.size()][2];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = fresh.get(i);
        }
        return newArray;
    }

}
