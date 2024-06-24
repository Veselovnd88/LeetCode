package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VeselovND <br>
 * created at 24.06.2024 <br>
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    //fast
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            Integer index = map.get(s.charAt(right)); //ищем индекс текущего символа
            if (index == null) {
                max = Math.max(max, right - left + 1); //если индекса еще нет, то обновляем максимум, и вставляем в мапу символ с индексом
                map.put(s.charAt(right), right);
                right++;
                //если индекс уже есть (=повтор символа), то смотрим, если индекс в пределах диапазона то сдвигаем сабстрингу
            } else {
                if (index >= left && index < right) {
                    left = index + 1;
                }
                max = Math.max(max, right - left + 1); //обновляем максимум
                map.put(s.charAt(right), right); //изменили индекс
                right++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstringSlow(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int slow = 0;
        int fast;
        int maxLength = 0;
        while (slow < s.length() - 1) {
            int length = 1;
            fast = slow + 1;
            while (fast < s.length()) {
                char nextChar = s.charAt(fast);
                String substring = s.substring(slow, fast);
                if (substring.contains(String.valueOf(nextChar))) {
                    break;
                } else {
                    length++;
                    fast++;
                }
            }
            maxLength = Math.max(maxLength, length);
            slow++;
        }
        return maxLength;
    }

}
