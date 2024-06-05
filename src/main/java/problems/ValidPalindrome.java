package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author VeselovND <br
 * created at 05.06.2024 <br>
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase(); //сразу привели в прописным
        List<Character> cleanedChars = new ArrayList<>(); //почистили от лишних символов
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleanedChars.add(c);
            }
        }
        //идем до середины и проверяем символы на равенство
        for (int i = 0; i < cleanedChars.size() / 2; i++) {
            if (!Objects.equals(cleanedChars.get(i), cleanedChars.get(cleanedChars.size() - 1 - i))) {
                return false;
            }
        }
        return true;

        //this is too slow
/*
        int first = 0;
        int last = s.length() - 1;

        while (first < last) {
            char firstChar = s.charAt(first);
            if (!Character.isLetterOrDigit(firstChar)) {
                first++;
                continue;
            }

            char lastChar = s.charAt(last);
            if (!Character.isLetterOrDigit(lastChar)) {
                last--;
                continue;
            }
            if (s.toLowerCase().charAt(first) != s.toLowerCase().charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;*/
    }
}
