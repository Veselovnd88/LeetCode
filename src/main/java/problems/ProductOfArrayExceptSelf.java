package problems;

import java.util.Arrays;

/**
 * @author VeselovND <br>
 * created at 02.07.2024 <br>
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">Product of array except self</a>
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        //Рассчитываем произведения элементов слева (префиксы) и справа (суффиксы)
        //получается, что в одном массиве будут произведения всех значений слева, а в другом массиве - всех значений справа
        //для того чтобы получить произведения всех для конкретного значения (мы берем произведение того что слева и умножаем на произведение того что справа)
        int[] answer = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            answer[j] *= suffix;
            suffix *= nums[j];
        }
        return answer;
    }
}
