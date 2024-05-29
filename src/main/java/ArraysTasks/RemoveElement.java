package ArraysTasks;

import java.util.Arrays;

/**
 * @author VeselovND
 * created at 29.05.2024
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arr, 2));
        int[] arr2 = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(arr2, 3));
        int[] arr3 = new int[]{1};
        System.out.println(removeElement(arr3, 1));
        int[] arr4 = new int[]{1, 1};
        System.out.println(removeElement(arr4, 1));
        int[] arr5 = new int[]{4, 5};
        System.out.println(removeElement(arr5, 5));
        int[] arr6 = new int[]{};
        System.out.println(removeElement(arr6, 5));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int tailIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[tailIndex] == val) {
                tailIndex--;
                continue;
            }
            if (nums[i] == val) {
                nums[i] = nums[tailIndex];
                nums[tailIndex] = val;
                tailIndex--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return tailIndex+1;
    }

}
