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


    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> intervalsList = new ArrayList<>();
        //сначала собираем интервалы которые не пересекаются хвостом с началом
        while (i < n && intervals[i][1] < newInterval[0]) {
            intervalsList.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]) { //здесь мы смотрим интервалы которые пересекаются
            //до тех пор пока не начнутся те интервалы у которых хвост больше чем голова нового
            //расширяем интервал, голова - наименьший (либо интервал, либо новый)
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        intervalsList.add(newInterval);

        while (i < n) {
            intervalsList.add(intervals[i++]);
        }
        return intervalsList.toArray(new int[intervalsList.size()][2]);
    }

}
