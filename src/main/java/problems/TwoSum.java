package problems;

import java.util.Arrays;

/**
 * @author VeselovND
 * created at 31.05.2024
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};

         System.out.println(Arrays.toString(solution(arr, 9)));

        int[] arr2 = {3, 2, 4};
        System.out.println(Arrays.toString(solution(arr2, 6)));

        int[] arr3 = {3, 3};
          System.out.println(Arrays.toString(solution(arr3, 6)));

        int[] arr4 = {3, 2, 3};
         System.out.println(Arrays.toString(solution(arr4, 6)));
    }

    public static int[] solution(int[] nums, int target) {
        int slow = 0;

        while (slow < nums.length - 1) {
            int fast = slow + 1;
            int diff = target - nums[slow];
            while (fast < nums.length) {
                if (nums[fast] == diff) {
                    return new int[]{slow, fast};
                }
                fast++;
            }
            slow++;
        }
        return new int[]{-1, -1};
    }
}
