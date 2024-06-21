package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author VeselovND <br>
 * created at 21.06.2024 <br>
 * <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 */
public class BinaryMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix1)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        Deque<int[]> cells = new ArrayDeque<>();
        //сначала заполняем все ненулевые ячейки максимальными значениями, для дальнейшего сравнения
        //а нулевые добавляем в очередь
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    distances[i][j] = Integer.MAX_VALUE;
                } else {
                    cells.add(new int[]{i, j});
                }
            }
        }
        // Потом берем нулевые ячейки и проверяем их соседей, если у соседей есть не нули - то проверяем
        // если значение ячейки больше чем путь до нашей ячейки - то обновляем его
        //например, если у нас ноль в рядом стоит 1 - то значит минимальное расстояние до 0 это 0+1
        while (!cells.isEmpty()) {
            int[] poll = cells.poll();

            int upperIdx = poll[0] - 1;
            int currCellCalue = distances[poll[0]][poll[1]];
            if (upperIdx >= 0 && upperIdx < m) {
                if (distances[upperIdx][poll[1]] > currCellCalue + 1) {
                    distances[upperIdx][poll[1]] = currCellCalue + 1;
                    cells.add(new int[]{upperIdx, poll[1]});
                }
            }

            int downIdx = poll[0] + 1;
            if (downIdx >= 0 && downIdx < m) {
                if (distances[downIdx][poll[1]] > currCellCalue + 1) {
                    distances[downIdx][poll[1]] = currCellCalue + 1;
                    cells.add(new int[]{downIdx, poll[1]});
                }
            }

            int leftIdx = poll[1] - 1;
            if (leftIdx >= 0 && leftIdx < n) {
                if (distances[poll[0]][leftIdx] > currCellCalue + 1) {
                    distances[poll[0]][leftIdx] = currCellCalue + 1;
                    cells.add(new int[]{poll[0], leftIdx});
                }
            }

            int rightIdx = poll[1] + 1;
            if (rightIdx >= 0 && rightIdx < n) {
                if (distances[poll[0]][rightIdx] > currCellCalue + 1) {
                    distances[poll[0]][rightIdx] = currCellCalue + 1;
                    cells.add(new int[]{poll[0], rightIdx});
                }
            }
        }
        return distances;
    }

    public static int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int maxPossible = mat.length - 1 + mat[0].length - 1;
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //смотрим только верхние и  левые ячейки (т.к. они уже пройденные и если с ними ничего
                //если там был ноль - то мы ничего не делали, если нет - то уже что-то было проделано
                if (mat[i][j] != 0) {
                    int up = (i > 0) ? distances[i - 1][j] : maxPossible; //если верхняя ячейка уже посчитана - то берем значение из таблицы
                    //если нет, то присваиваем максимальное
                    int left = (j > 0) ? distances[i][j - 1] : maxPossible;
                    distances[i][j] = Math.min(up, left) + 1; //+1 т.к. мы должны прибавить к предыдущему
                }
            }
        }
        //снизу вверх, справа на лево
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int down = (i < mat.length - 1) ? distances[i + 1][j] : maxPossible; //если верхняя ячейка уже посчитана - то берем значение из таблицы
                    //если нет, то присваиваем максимальное
                    int right = (j < mat[0].length - 1) ? distances[i][j + 1] : maxPossible;
                    distances[i][j] = Math.min(Math.min(down, right) + 1, distances[i][j]); //+1 т.к. мы должны прибавить к предыдущему
                }
            }
        }

        return distances;
    }


}
