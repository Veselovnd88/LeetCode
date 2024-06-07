package problems;

import java.util.Arrays;

/**
 * @author VeselovND <br>
 * created at 07.06.2024 <br>
 * <a href="https://leetcode.com/problems/flood-fill/description/">Flood Fill</a>
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] ints = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(floodFill(ints, 1, 1, 2)));
        int[][] ints2 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(floodFill(ints2, 0, 0, 0)));
        int[][] ints3 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(floodFill(ints3, 1, 0, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image; //если уже покрашен, то ничего не делаем
        changeColor(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private static void changeColor(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r - 1 >= 0) changeColor(image, r - 1, c, color, newColor); //если пиксель слева не выходит за края
            if (r + 1 < image.length)
                changeColor(image, r + 1, c, color, newColor); //если пиксель справа не выходит за края
            if (c - 1 >= 0) changeColor(image, r, c - 1, color, newColor); //также вверх и вниз
            if (c + 1 < image[0].length) changeColor(image, r, c + 1, color, newColor);
        }
    }
}
