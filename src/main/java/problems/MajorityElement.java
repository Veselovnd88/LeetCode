package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VeselovND <br>
 * created at 17.06.2024 <br>
 * <a href="https://leetcode.com/problems/majority-element/description/">Majority Element</a>
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : nums) {
            map.putIfAbsent(elem, 1);
            Integer i1 = map.get(elem);
            map.put(elem, i1 + 1);
            if (i1 > nums.length / 2) {
                return elem;
            }
        }
        return -1;
    }
}
