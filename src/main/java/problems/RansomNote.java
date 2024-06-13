package problems;

/**
 * @author VeselovND <br>
 * created at 13.06.2024 <br>
 *
 * <a href="https://leetcode.com/problems/ransom-note/description/">Ransom Note</a>
 */
public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26]; //each position is number of character
        //counting letters
        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++; // count letter positions ('a' positions would be 0)
        }
        //decreasing letters count
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--counts[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
