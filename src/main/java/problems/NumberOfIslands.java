package problems;

/**
 * @author VeselovND <br>
 * created at 05.07.2024 <br>
 * <a href="https://leetcode.com/problems/number-of-islands/description/">Number of Islands</a>
 */
public class NumberOfIslands {

    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        //идем по матрице, если встречается 1, то увеличиваем количество островов на 1, и по цепочке идем по всем
        //соседствующим островам отмечая их 0
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(char[][] grid, int row, int col) {
        //берем остров, проверяем всех соседей и помечаем их 0, проверяя границы
        int m = grid.length;
        int n = grid[0].length;
        grid[row][col] = '0'; //отмечаем посещенным
        int[] directions = {-1, 0, 1, 0, -1}; //направления
        for (int k = 0; k < 4; k++) {
            int newCol = col + directions[k];
            int newRow = row + directions[k + 1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
                dfs(grid, newRow, newCol);
            }
        }
    }

}
