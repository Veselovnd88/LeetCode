package problems;

/**
 * @author VeselovND
 * created at 03.06.2024
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("10 " + isPalindrome(10));
        System.out.println("11 " + isPalindrome(11));
        System.out.println("-10 " + isPalindrome(-10));
        System.out.println("121 " + isPalindrome(121));
        System.out.println("3333 " + isPalindrome(3333));
    }


    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        if (num / 10 == 0) { //if only 1 digit - it is palindrome
            return true;
        }
        int divisions = 1;

        while (num / divisions >= 10) { // to define how to get left number
            divisions *= 10;
        }

        while (num != 0) {
            int left = num / divisions;
            int right = num % 10;
            if (left != right) {
                return false;
            }
            num = (num % divisions) / 10; //get number between left and right
            divisions /= 100; //100 because we remove 2 divisions
        }
        return true;
    }
}
