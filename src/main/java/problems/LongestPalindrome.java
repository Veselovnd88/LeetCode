package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VeselovND <br>
 * created at 14.06.2024 <br>
 * <a href="https://leetcode.com/problems/longest-palindrome/description/">Longest Palindrome</a>
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        //Собираем все буквы в мапу и и определяем их количество
        //ищем пары и проверяем, есть ли одиночные элементы
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean hasSingle = false;
        int evens = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                evens += entry.getValue() / 2;
            } else {
                int pairs = entry.getValue() / 2;
                evens += pairs;
                hasSingle = true;
            }
        }
        if (hasSingle) {
            return evens * 2 + 1;
        }
        return evens * 2;
    }
}
