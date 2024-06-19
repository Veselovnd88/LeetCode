package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author VeselovND <br>
 * created at 19.06.2024 <br>
 * <a href="https://leetcode.com/problems/contains-duplicate/description/">Contains Duplicate</a>
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int n : nums) {
            if (duplicates.contains(n)) {
                return true;
            } else {
                duplicates.add(n);
            }
        }
        return false;
    }
}
