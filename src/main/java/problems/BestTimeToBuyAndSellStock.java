package problems;

/**
 * @author VeselovND
 * created at 05.06.2024 <br>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">Best Time to Buy and Sell Stock</a>
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{2, 1, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        //одновременно идем по массиву  - ищем минимальную цену для покупки, и пересчитываем возможную продажу
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //проверяю, если цена по которой купили больше чем предлагаемая (можно купить дешевле, то присваиваем ее)
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) { //если нет, то проверяем, что разница купли-продажи больше текущей
                profit = prices[i] - buy; //если больше то пересчитываем
            }
        }
        return profit;
    }
}
