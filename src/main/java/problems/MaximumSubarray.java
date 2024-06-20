package problems;

/**
 * @author VeselovND <br>
 * created at 20.06.2024 <br>
 * <a href="https://leetcode.com/problems/maximum-subarray/description/">Maximum Subarray</a>
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        //идем по массиву начиная с первого элемента
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); //обновляем максимум (либо сумма, либо текущий элемент)
            maxSum = Math.max(currentSum, maxSum); //и обновляем максимум
        }
        return maxSum;
    }
}
