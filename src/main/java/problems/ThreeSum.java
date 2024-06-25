package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author VeselovND <br>
 * created at 25.06.2024 <br>
 * <a href="https://leetcode.com/problems/3sum/description/">3sum</a>
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int left;
        int right;
        //Сортируем
        Arrays.sort(nums);
        //чтобы убрать дубликаты складываем всё в сет
        Set<List<Integer>> result = new HashSet<>();

        //идем по массиву, берем первый элемент, находим остаток для вычисления суммы двух других
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            //берем левый и правый указатели (маленький и большой, чтобы понимать в какую сторону двигаться)
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    //нашли пару, и сложили всё в лист, сдвинули левый указатель
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[left]);
                    triple.add(nums[right]);
                    result.add(triple);
                    left++;
                } else if (sum < target) {
                    //если получившаяся сумма меньше необходимой, значит левое число слишком маленькое и нам нужно двигать левый указатель
                    left++;
                } else {
                    // и наоборот, если сумма слишком большая, то двигаем правый указатель
                    right--;
                }
            }
        }
        return result.stream().toList();
    }

}
