package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author VeselovND
 * created at 31.05.2024
 * https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31
 */
public class SingleNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(viaSet(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public static int[] viaSet(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            if (set.contains(j)) {
                set.remove(j);
            } else {
                set.add(j);
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}
