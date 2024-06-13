package problems;

/**
 * @author VeselovND <br>
 * created at 13.06.2024 <br>
 * <a href="https://leetcode.com/problems/first-bad-version/description/">First Bad Version</a>
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        //находим границу где начинаются слева плохие элементы (бинарным поиском)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isBad = isBadVersionFor5(mid);
            if (isBad) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //возвращаем первый левый плохой элем
        return left;
    }

    private static boolean isBadVersionFor5(int n) {
        return n >= 4;
    }
}
