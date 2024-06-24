package problems;

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

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length()==1) {
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
