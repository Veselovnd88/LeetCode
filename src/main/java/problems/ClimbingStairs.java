package problems;

/**
 * @author VeselovND <br>
 * created at 14.06.2024 <br>
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">Climbing Stairs</a>
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairsRecursive(int n) {
        //базовые случаи для рекурсии
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //задача разбивается на небольшие подзадачи пока не дойдут до базовым случаем
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public static int climbStairs(int n) {
        //Динамическое программирование, каждый следующий результат - это результат двух предыдущих (если с шагнули с предыдущей ступеньки и ступеньки-2)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
