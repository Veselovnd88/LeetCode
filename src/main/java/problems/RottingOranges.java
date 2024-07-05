package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 05.07.2024 <br>
 * <a href="https://leetcode.com/problems/rotting-oranges/description/">Rotting organges</a>
 */
public class RottingOranges {

    public static void main(String[] args) {

    }

    public static int orangesRotting(int[][] grid) {
        //Сначала собираем те апельсины которые на начальной стадии плохие
        Deque<int[]> deque = new ArrayDeque<>();
        int freshCount = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new int[]{i, j});
                } else if (grid[i][j] == 1) { //помечаем хорошие апельсины
                    freshCount++;
                }
            }
        }
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};// вверх, вниз, влево, вправо
        int minutes = 0;
        while (freshCount > 0 && !deque.isEmpty()) {
            minutes++;
            int rottens = deque.size();// для каждого плохого апельсина, заражаем все по сторонам
            while (rottens-- > 0) {
                int[] rotten = deque.poll();
                for (int[] side : direction) {
                    int row = rotten[0] + side[0];
                    int col = rotten[1] + side[1];
                    //проверяем на границы и наличие свежего апельсина
                    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == 2) {
                        continue;
                    }
                    deque.add(new int[]{row, col});
                    grid[row][col] = 2;
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
