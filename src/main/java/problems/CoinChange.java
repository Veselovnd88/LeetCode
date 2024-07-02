package problems;

import java.util.Arrays;

/**
 * @author VeselovND <br>
 * created at 02.07.2024 <br>
 * <a href="https://leetcode.com/problems/coin-change/">Coin Change</a>
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 5};
        System.out.println(coinChange(ints, 7));
    }

    public static int coinChange(int[] coins, int amount) {

        //Динамическое программирование
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); //заполняем все суммы макс значениями, количество монет для получения данной суммы
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int value : coins) {
                //если сумма за вычетом монеты с номиналом больше 0 и значение в в ячейке для получения той суммы не макс
                //то берем минимальное из: текущее значение и предыдущее значение +1
                //
                if (i - value >= 0 && dp[i - value] != Integer.MAX_VALUE) {// проверка на то, что значение можно получить, и что предыдущее зн получено
                    //дальше мы проверяем, как можно получить данную сумму с учетом посчитанных данных
                    //например для {1,3,4,5} и 7 : при 1 (мы берем 1+ то что требуется для получения 6 (2)=3)
                    //при 3, мы берем 1+ то что требуется для получения (7-3=4) четырех (1 монета), соответ. 2
                    //и выбираем минимальное значение
                    dp[i] = Math.min(dp[i], 1 + dp[i - value]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else return dp[amount];
    }

}
