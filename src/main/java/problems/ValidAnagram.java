package problems;

import java.util.Arrays;

/**
 * @author VeselovND <br>
 * created at 06.06.2024 <br>
 * <a href="https://leetcode.com/problems/valid-anagram/description/">Valid Anagram</a>
 */
public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //сортируем два массива чаров и проверяем, одинаковые они или нет
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }
}
